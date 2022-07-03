package lzf.Hw;

import java.util.*;

/**
 * 第 k 长子串
 * https://blog.csdn.net/weixin_41802443/article/details/123954159
 */
public class Code_25_4 {
    public static void main(String[] args) {
//        String s = "AABAAA";
//        int k = 1;
        String s = "AAAAHHHBBCDHHHH";
        int k = 3;
        Map<String, Integer> map = new HashMap<>();
        String[] string = s.split("");
        int count = 1;
        String preString = string[0];
        for (int i = 1; i < string.length; i++) {
            if (i< string.length - 1) {
                if (string[i].equals(preString)){
                    count++;
                    preString = string[i];
                }else {
                    map.put(preString,count);
                    count=1;
                    preString = string[i];
                }
            }else {
                if (string[i].equals(preString)){
                    count++;
                    if (map.containsKey(string[i])){
                        if (map.get(string[i]) < count){
                            map.put(string[i],count);
                        }
                    }else {
                        map.put(string[i],count);
                    }
                }else {
                    map.put(string[i],1);
                }
            }

        }
        System.out.println(map);
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(list);
        if (list.size() > k){
            System.out.println(list.get(k-1).getValue());
        }else {
            System.out.println(-1);
        }
        /*List<Integer> list = new ArrayList<>(map.values());
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });*/
/*        System.out.println(list);
        System.out.println(list.get(k-1));*/
    }
}
