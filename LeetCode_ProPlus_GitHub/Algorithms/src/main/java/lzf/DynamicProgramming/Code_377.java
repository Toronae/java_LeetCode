package lzf.DynamicProgramming;

/**
 * 完全背包
 * 完全背包递推公式：dp[i] += dp[i - nums[j]];
 * 01背包递推公式：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
 *           或者dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
 */
public class Code_377 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(new Code_377().combinationSum4(nums,target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
