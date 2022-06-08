package lzf.Greedy;

public class Code_55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Code_55().canJump(nums));
    }

    // 贪心
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover,i+nums[i]);
            if (cover >= nums.length -1) {
                return true;
            }
        }
        return false;
    }

    // 动态规划
    /*public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[nums.length - 1];
    }*/

}
