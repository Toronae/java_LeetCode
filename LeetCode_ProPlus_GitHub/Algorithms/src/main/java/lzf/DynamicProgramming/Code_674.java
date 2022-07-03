package lzf.DynamicProgramming;

/**
 * 子序列问题（连续）
 * 最长连续递增序列
 */
public class Code_674 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(new Code_674().findLengthOfLCIS(nums));
    }
    /**
     * 1.dp[i] 代表当前下表最大连续值
     * 2.递推公式 if（nums[i+1]>nums[i]） dp[i+1] = dp[i]+1
     * 3.初始化 都为1
     * 4.遍历方向，从其那往后
     * 5.结果推导 。。。。
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}
