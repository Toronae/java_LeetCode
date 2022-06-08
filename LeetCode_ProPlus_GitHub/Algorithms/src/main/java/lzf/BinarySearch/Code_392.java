package lzf.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_392 {
    public static void main(String[] args) {
        String s = "aec";
        String t = "abcde";
        System.out.println(new Code_392().isSubsequence(s,t));
    }

    // 二分法
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            List<Integer> list = map.get(t.charAt(i));
            if (list == null) {
                list = new ArrayList<>();
                map.put(t.charAt(i), list);
            }
            if (list.size() > 0 && list.get(list.size() - 1) == i) {
                continue;
            }
            list.add(i);
        }

        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.get(s.charAt(i));
            if (list == null) {
                return false;
            }
            boolean found = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > last) {
                    last = list.get(j);
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }


    // 暴力
    /*public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c,index+1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }*/
}
