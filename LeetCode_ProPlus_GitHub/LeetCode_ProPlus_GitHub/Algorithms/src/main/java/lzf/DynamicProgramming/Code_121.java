package lzf.DynamicProgramming;

public class Code_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Code_121().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = (dp[i - 1] < prices[i]) ? dp[i - 1] : prices[i];
            max = (prices[i] - dp[i]) > max ? prices[i] - dp[i] : max;
        }
        return max;
    }
}
