package lzf.DynamicProgramming;

public class Code_416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Code_416().canPartition(nums));
    }

    /**
     * 01背包
     * 思想：转换为01背包问题
     * dp[i][j]:容量为j的前i个物品所能组成的最大价值
     * bagsize:sum/2  weight[i]:nums[i]  value[i]:nums[i]
     * 原因：当容量为sum/2时如果刚好能装满，那么最后对应的最大价值一定是sum/2,因为 每块物品的重量和价值是相等的，你装进了sum/2的重量(前面刚说了装满的情况下)，那么它的价值一定是sum/2
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        //初筛
        if(sum % 2 == 1){
            return false;
        }
        //动态规划
        //背包容量
        int target = sum / 2;
        int[][] dp = new int[nums.length+1][target+1];
        //采用二维dp:物品是从第一个物品开始、背包也是从容量为1开始(0行、0列都已经初始化过了，所以前期dp数组无需再初始化了)
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                //注意这里为什么不是nums[i]呢？是因为nums索引与dp数组索引本身就差1
                // 这行代码的意思是：判断当前容量能不能容下当前物品
                if(j < nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }

            }
        }
        return dp[nums.length][target] == target;
    }
}
