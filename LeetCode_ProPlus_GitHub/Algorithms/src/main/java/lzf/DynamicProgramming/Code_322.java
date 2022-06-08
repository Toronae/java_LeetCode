package lzf.DynamicProgramming;

public class Code_322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Code_322().coinChange(coins,amount));
    }
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount+1];
        //凑足总额为i所需钱币的最少个数为dp[i]
//        Arrays.fill(dp, max);
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                if (dp[j-coins[i]] != max) {
                    dp[j] = Math.min(dp[j],dp[j-coins[i]] +1);
                }
            }
        }
        return dp[amount] == max ? -1 :dp[amount];
    }
}
