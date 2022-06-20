package lzf.Greedy;

public class Code_714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new Code_714().maxProfit(prices,fee));
    }
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;
        for (int p : prices) {
            if (p + fee < buy) {
                buy = p + fee;
            } else if (p > buy){
                sum += p - buy;
                buy = p;
            }
        }
        return sum;
    }
}
