package lzf.DynamicProgramming;

import java.util.Arrays;

public class Code_213 {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(new Code_213().rob(nums));
    }
    public int rob(int[] nums) {
        //将环分成0 - n-1 和 1 - n
        //转移方程: dp[n] = Math.max(dp[n-1], dp[n-2] + nums[n])
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robber(Arrays.copyOfRange(nums,0,nums.length - 1)), robber(Arrays.copyOfRange(nums,1,nums.length)));
    }


    int robber(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }
}
