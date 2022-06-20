package lzf.Greedy;

public class Code_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Code_121().maxProfit(prices));
    }
    // 贪心
    public int maxProfit(int[] prices) {
        //解题思路：一次循环找到历史最低点股价，与当前价格判断更新最大利润；
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            //当天是历史最低点则买入，但还没有利润
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                //否则计算更新最大利润
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }
}
