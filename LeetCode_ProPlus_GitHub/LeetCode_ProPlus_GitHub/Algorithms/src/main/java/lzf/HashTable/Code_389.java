package lzf.HashTable;

import java.util.HashMap;

public class Code_389 {
    //hash表有两种实现：1.自带函数，2.数组
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(new Code_389().findTheDifference(s,t));
    }
    public char findTheDifference(String s, String t) {
        HashMap< Character,Integer> map = new HashMap<>();
        char answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            } else {
                int temple = map.get(s.charAt(i))+1;
                map.put(s.charAt(i),temple);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if(map.get(t.charAt(i))==null){
                answer =t.charAt(i);
            } else if(map.get(t.charAt(i))!=0){
                int temple = map.get(t.charAt(i))-1; map.put(t.charAt(i),temple);
            } else {
                answer =t.charAt(i);
            }
        }
        return answer;
    }

    /*public char findTheDifference(String s, String t) {
        char res = (char) (t.chars().sum()-s.chars().sum());
        return res;
    }*/
}
