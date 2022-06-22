package lzf.SlidingWindow;

import java.util.HashMap;

public class Code_567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(new Code_567().checkInclusion(s1,s2));
    }
    public boolean checkInclusion(String s1, String s2) {
        int sz = s2.length();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c : s1.toCharArray()){
            need.put(c, need.getOrDefault(c,0)+1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while(right < sz){
            //进来的字符
            char c = s2.charAt(right);
            right++; //扩大窗口
            //改变窗口状态
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //判断是否要收缩
            while(valid == need.size()){
                //子串包含s1的全部字符 且 长度相等 即 满足题意
                if(right - left == s1.length()) {
                    return true;
                }
                //要移出的字符
                char d = s2.charAt(left);
                left++; //缩小窗口
                //改变窗口状态
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d,0)-1);
                }
            }
        }
        return false;
    }
}
