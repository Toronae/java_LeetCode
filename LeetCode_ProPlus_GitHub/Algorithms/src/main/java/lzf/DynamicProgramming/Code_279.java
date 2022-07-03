package lzf.DynamicProgramming;

/**
 * 完全背包
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量
 */
public class Code_279 {
    public static void main(String[] args) {
        int n =12;
        System.out.println(new Code_279().numSquares(n));
    }
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
