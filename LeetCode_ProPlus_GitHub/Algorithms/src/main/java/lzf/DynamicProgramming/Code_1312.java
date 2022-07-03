package lzf.DynamicProgramming;

/**
 * 让字符串成为回文串的最少插入次数
 */
public class Code_1312 {
    public static void main(String[] args) {
        String s = "zzazz";
        System.out.println(new Code_1312().minInsertions(s));
    }
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 0;
        }
        for (int i = len-2; i >= 0 ; i--) {
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[0][len-1];
    }
}
