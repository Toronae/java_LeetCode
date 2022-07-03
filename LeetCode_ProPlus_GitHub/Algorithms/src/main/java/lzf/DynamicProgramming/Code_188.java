package lzf.DynamicProgramming;

import java.util.Arrays;

public class Code_188 {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2,4,1};
        System.out.println(new Code_188().maxProfit(k,prices));
    }
    public int maxProfit(int k, int[] prices) {
        // 若想获取利润，一买一卖需要2天.同一天买卖,利润为0
        // 获取真实的最大交易次数,
        k = Math.min(k, prices.length/2);
        /*
            由于可以交易k次，则某一天结束后的状态为k*2种
            定义某一天的2种操作：买buy与卖sell
            由于以0为起点，所以数组长度定义为k+1
        */
        // 由于后面进行的是取最大值max的操作，这里赋初值只是为了做初始对比。
        int[] buy = new int[k+1]; Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k+1]; Arrays.fill(sell, 0);
        for (int p:prices){
            // 更新k*2种状态
            for(int i = 1; i < k+1; i++){
                // 目标就是使得自己手里剩下的钱最多
                // 如果第i天你买股票，剩下的钱=第i天之前赚的钱sell[i-1]-第i天购买股票的钱p
                buy[i] = Math.max(buy[i], sell[i-1] - p);
                sell[i] = Math.max(sell[i], buy[i] + p);
            }
        }
        // 返回完成k次交易后最大利润
        return sell[k];
    }

    public int maxProfit1(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }
}
