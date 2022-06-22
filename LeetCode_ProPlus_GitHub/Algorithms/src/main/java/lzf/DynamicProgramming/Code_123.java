package lzf.DynamicProgramming;

public class Code_123 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(new Code_123().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = prices[0], sell1 = 0;
        int buy2 = prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
}
