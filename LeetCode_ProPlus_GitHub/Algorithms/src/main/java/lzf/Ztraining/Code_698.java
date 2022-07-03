package lzf.Ztraining;

import java.util.Arrays;

public class Code_698  {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(new Code_698().canPartitionKSubsets(nums,k));
    }
    int bucket[];
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k==1){
            return true;
        }
        int sum = 0;
        for (int num:nums) {
            sum+=num;
        }
        if (sum %k != 0){
            return false;
        }
        sum = sum / k;
        Arrays.sort(nums);
        bucket = new int[k];
        Arrays.fill(bucket,sum);
        int len = nums.length;
        return dfs(nums,k,len-1);
    }

    private boolean dfs(int[] nums, int k, int len) {
        if (len<0){
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (bucket[i] == nums[len] || bucket[i] -nums[len] >= nums[0]){
                bucket[i] -= nums[len];
                if (dfs(nums,k,len-1)){
                    return true;
                }
                bucket[i] += nums[len];
            }
        }
        return false;
    }
}
