package lzf.DynamicProgramming;

public class Code_343 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Code_343().integerBreak(n));
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <=n ; i++) {
            for (int j = 1; j < i-1; j++) {
                dp[i] =Math.max(dp[i],Math.max(j*(i-j),dp[i-j]*j));
            }
        }
        return dp[n];
    }
}
