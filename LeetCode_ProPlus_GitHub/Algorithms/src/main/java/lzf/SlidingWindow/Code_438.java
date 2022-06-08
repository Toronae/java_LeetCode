package lzf.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new Code_438().findAnagrams(s,p));
    }
    public List<Integer> findAnagrams(String s, String p) {
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
