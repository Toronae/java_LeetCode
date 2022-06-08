package lzf.SlidingWindow;

import java.util.HashMap;

public class Code_3 {
    public static void main(String[] args) {
        String s =  "abcabcbb";
        System.out.println(new Code_3().lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
