package lzf.DynamicProgramming;

/**
 * 子序列问题（不连续）
 * 最长递增子序列
 */
public class Code_300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Code_300().lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        // dp[i]：第i个最长递增子序列长度
        int[] dp = new int[nums.length];
        // 记录最长递增子序列长度
        int max = 0;
        // 从第一个数开始统计
        for(int i=0;i<nums.length;i++){
            // 只要有数，则最短也是1，初始化为1
            dp[i]=1;
            // 与这个数之前的最长递增子序列长度比较
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    // 递增情况下：取最大递增子序列长度
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            // 每个数更新完毕后随时更新最大子序列长度
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
