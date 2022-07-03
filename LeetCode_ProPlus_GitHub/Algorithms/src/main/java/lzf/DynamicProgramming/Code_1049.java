package lzf.DynamicProgramming;

/**
 * 01背包
 * 可以抽象为将n块石头分为两堆，而后求两堆石头重量总和的最小差值
 * 因此便可看为01背包问题，背包最大容量为这n块石头总重量的一半
 * 那么理想情况下，如果可以刚好装满背包，两堆石头重量总和的最小差值便可为零
 */
public class Code_1049 {
    public static void main(String[] args) {

    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int num:stones){
            sum += num;
        }
        //背包容量上限为石头总重量的一半
        //dp[i][j]的含义为当可选石头为前i个时，容量为j的背包所能存放的实际最大值
        int dp[][] = new int[n+1][sum/2+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum/2;j++){
                //当我能把这块石头放进背包时，我会比较放或不放，选择最大值
                if(j>=stones[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i-1]] + stones[i-1]);
                } else {
                    //这块石头放不进背包时，只能跳过
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //dp[n][sum/2]的最大值为sum/2，因此最理想的结果为0
        return sum-dp[n][sum/2]*2;
    }
}
