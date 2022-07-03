package lzf.Ztraining;

import java.util.Arrays;

public class Code_416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Code_416().canPartition(nums));
    }
    int[] bucket;
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum %2 != 0) {
            return false;
        }
        sum /= 2;
        bucket = new int[2];
        Arrays.fill(bucket,sum);
        Arrays.sort(nums);
        return dfs(nums,2,len-1);

    }

    private boolean dfs(int[] nums, int k, int len) {
        if (len < 0) {
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (bucket[i] == nums[len] ||bucket[i] - nums[len] >=nums[0]){
                bucket[i] -= nums[len];
                if (dfs(nums,2,len-1)){
                    return true;
                }
                bucket[i] += nums[len];
            }
        }
        return false;
    }
}
