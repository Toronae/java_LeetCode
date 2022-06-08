package lzf.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class Code_1456 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(new Code_1456().maxVowels(s,k));
    }
    public int maxVowels(String s, int k) {
        char[] c = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(c[i])) {
                ans++;
            }
        }
        int window = ans;
        for (int left = 0,right = k;right<c.length;left++,right++) {
            if (set.contains(c[left])) {
                window--;
            }
            if (set.contains(c[right])) {
                window++;
            }
            ans = Math.max(ans,window);
        }
        return ans;
    }
}
