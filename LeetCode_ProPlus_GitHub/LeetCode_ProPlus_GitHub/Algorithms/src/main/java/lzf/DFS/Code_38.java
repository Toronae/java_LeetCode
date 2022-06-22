package lzf.DFS;

public class Code_38 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Code_38().countAndSay(n));
    }
    // 21 -> 1211 , 1211 ->111221

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }else {
            String res = countAndSay(n-1);
            StringBuilder sb = new StringBuilder();
            int left = 0, right = 1,len = res.length();
            while (right < len) {
                if (res.charAt(left) != res.charAt(right)) {
                    sb.append(right-left).append(res.charAt(left));
                    left = right;
                }
                right++;
            }
            return sb.append(right-left).append(res.charAt(left)).toString();
        }
    }
}
