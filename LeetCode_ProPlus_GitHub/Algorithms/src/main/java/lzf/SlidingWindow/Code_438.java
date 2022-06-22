package lzf.SlidingWindow;

import java.util.*;

public class Code_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new Code_438().findAnagrams(s,p));
    }
    //滑窗
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> result = new ArrayList<>();
        while (right <= s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗⼝是否要收缩
            while (right - left >= p.length()) {
                // 终止条件
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                //移动left
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return result;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> res = new ArrayList<>();
        if(m<n)return res;
        int[] sc = new int[26];
        int[] pc = new int[26];
        for(int i = 0;i<n;i++){
            sc[s.charAt(i)-'a']++;
            pc[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sc,pc)){
            res.add(0);
        }
        for(int i = n;i<m;i++){
            sc[s.charAt(i-n)-'a']--;
            sc[s.charAt(i)-'a']++;
            if(Arrays.equals(sc,pc)){
                res.add(i-n+1);
            }
        }
        return res;
    }
}
