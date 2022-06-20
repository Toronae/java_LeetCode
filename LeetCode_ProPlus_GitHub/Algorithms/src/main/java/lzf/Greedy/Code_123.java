package lzf.Greedy;

import java.util.Stack;

/**
 *  先按照 121. 买卖股票的最佳时机（仅交易一次） 的方式计算出交易一次的最大获利，并记录该次交易 买入 和 卖出的索引值
 *  接下来有三种情况： 1.第二次交易在 买入 之前
 *                   2.第二次交易在卖出之后
 *                   3.在买入 和 卖出 内又存在一次买入和卖出
 *
 */
public class Code_123 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(new Code_123().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int buyIndex = 0;
        int saleIndex = 0;
        int first = 0;
        int oldBuyIndex = 0;
        Stack<Integer> stack = new Stack<>();
        //首先记录第一次买入和卖出的索引位置
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
                buyIndex = i;
            }
            else {
                if (prices[i] - min > first){
                    saleIndex = i;
                    first = prices[i] - min;
                    //在卖出的时候记录该次交易买入的索引
                    oldBuyIndex = buyIndex;
                }
            }
        }
        buyIndex = oldBuyIndex;//如果不进行这一步，会出现buyIndex > saleIndex eg:[2,4,1]
        //首先求出在buyIndex和saleIndex之间再进行交易的获利
        //第一次买入：a 第一次卖出：b   第二次买入：c  第二次卖出：d  只需要计算b-c的最大值
        int sonMain = 0;
        if (buyIndex + 1 < prices.length) {
            int sonMax = prices[buyIndex + 1];
            for (int i = buyIndex + 2; i < saleIndex; i++) {
                if (prices[i] > sonMax) {
                    sonMax = prices[i];
                } else {
                    sonMain = Math.max(sonMain, sonMax - prices[i]);
                }
            }
        }
        //计算第二次交易在左侧区间的获利最大值
        int secondL = 0;
        min = prices[0];
        for (int i = 1; i < buyIndex; i++) {
            if (prices[i] < min){
                min = prices[i];
            }
            else {
                secondL = Math.max(prices[i] - min ,secondL);
            }
        }
        //计算第二次交易在右侧区间的获利最大值
        int secondR = 0;
        if (saleIndex+1 < prices.length){
            min = prices[saleIndex + 1];
            for (int i = saleIndex + 2; i < prices.length; i++) {
                if (prices[i] < min){
                    min = prices[i];
                }
                else {
                    secondR = Math.max(prices[i] - min ,secondR);
                }
            }
        }
        //结果返回第一次交易加上  三种情况中获利的最大值
        return first + Math.max(sonMain,Math.max(secondL,secondR));
    }

}
