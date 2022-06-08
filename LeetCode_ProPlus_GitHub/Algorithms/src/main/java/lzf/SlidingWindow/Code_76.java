package lzf.SlidingWindow;

public class Code_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Code_76().minWindow(s,t));
    }
    public String minWindow(String s, String t) {
        if (s.length() ==0 ||t.length() > s.length()) {
            return "";
        }
        int[] map = new int[128];
        for (char c:t.toCharArray()) {
            map[c]++;
        }
        int left = 0;
        int right = 0;
        int count = t.length();
        int window = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c]-- >0){
                count--;
            }
            right++;
            while (count ==0) {
                if (window > right-left){
                    window = right-left;
                    start=left;
                }
                c = s.charAt(left++);
                if (map[c]++ >=0) {
                    count++;
                }
            }
        }
        return window == Integer.MAX_VALUE? "":s.substring(start,start+window);
    }
}
