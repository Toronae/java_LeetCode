package lzf.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class Code_1456 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(new Code_1456().maxVowels(s,k));
    }
    //滑窗
    public int maxVowels(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int cnt = 0;
        int res = 0;
        while (right < n) {
            cnt += isValid(s.charAt(right));
            if (right - left + 1 > k) {
                cnt -= isValid(s.charAt(left));
                left++;
            }
            if (right - left + 1 == k) {
                res = Math.max(res, cnt);
            }
            right++;
        }
        return res;
    }

    private int isValid(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return 1;
        }
        return 0;
    }

    public int maxVowels1(String s, int k) {
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
