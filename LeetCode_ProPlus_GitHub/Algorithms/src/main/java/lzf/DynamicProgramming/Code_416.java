package lzf.DynamicProgramming;

public class Code_416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Code_416().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for(int i = 0; i < n; i++){
            // 注意01背包的一维bp中对背包的体积要进行倒序遍历
            for(int j = target; j >= nums[i]; j--){
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
