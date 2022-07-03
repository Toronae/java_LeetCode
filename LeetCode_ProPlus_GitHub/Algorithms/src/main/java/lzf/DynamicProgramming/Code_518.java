package lzf.DynamicProgramming;

/**
 * 完全背包
 * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
 * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
 * 本题为求组合问题
 */
public class Code_518 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins ={1, 2, 5};
        System.out.println(new Code_518().change(amount,coins));
    }
    // dp[i]：凑成总金额j的货币组合数为dp[j]
    // 求装满背包有几种方法，一般公式都是：dp[j] += dp[j - nums[i]];
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
