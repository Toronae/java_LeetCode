package lzf.Hw;

public class Code_25_13 {
    public static void main(String[] args) {
        int n = 40;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-3];
        }
        System.out.println(dp[n]);
    }
}
