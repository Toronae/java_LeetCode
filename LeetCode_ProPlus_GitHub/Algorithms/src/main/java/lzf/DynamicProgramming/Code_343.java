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
                //要么就拆分为j何i-j两个数的乘积，要么继续拆分i-j为其他至少两个数的乘积，然后比较取乘积最大
                dp[i] =Math.max(dp[i],Math.max(j*(i-j),dp[i-j]*j));
            }
        }
        return dp[n];
    }
}
