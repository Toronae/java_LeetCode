package lzf.DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code_416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Code_416().canPartition(nums));
    }
    boolean result = false;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[] used = new boolean[nums.length];
        Map<Integer, Boolean> mem = new HashMap<>();
        dfs(nums, sum, used, mem);
        return result;
    }

    public void dfs(int[] nums, int sum, boolean[] used, Map<Integer, Boolean> mem) {
        if (sum == 0) {
            result = true;
            return;
        }
        //作用剪枝，满足条件不在继续递归求解
        if (mem.containsKey(sum)) {
            return;
        }
        // 此处减枝，已满足条件不在继续递归求解
        if (!result) {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    if (nums[i] <= sum) {
                        used[i] = true;
                        dfs(nums, sum - nums[i], used, mem);
                        used[i] = false;
                    }
                }
            }
            mem.put(sum, result);
        }
    }

    //invalidSet为无法凑出的目标集合

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum %2 != 0){
            return false;
        }

        Set<Integer> invalidSet = new HashSet<>();
        //boolean res =  helper(nums, 0, sum/2,  invalidSet);
        //System.out.println(invalidSet);
        //return res;
        return helper(nums, 0, sum/2,  invalidSet);
    }

    public boolean helper(int[] nums, int idx, int target, Set<Integer> invalidSet){
        if(target < 0 || invalidSet.contains(target)){
            return false;
        }

        if(target == 0){
            return true;
        }


        for(int i = idx;i<nums.length;i++){
            if(helper(nums, i+1, target - nums[i], invalidSet)) {
                return true;
            }
        }
        invalidSet.add(target);
        return false;
    }

    //
    private Map<Integer,Boolean>map=new HashMap<Integer,Boolean>();
    public boolean canPartition1(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums) {
            sum+=num;
        }
        if(sum%2!=0) {
            return false;
        }
        int target=sum/2;
        return dfs(nums,target,n,0);
    }

    public boolean dfs(int []nums,int target,int n,int idx){
        if(target==0) {
            return true;
        }
        if(target<0||idx>=n) {
            return false;
        }
        if(map.containsKey(target)) {
            return map.get(target);
        }
        boolean flag=false;
        if(target-nums[idx]>=0){
            flag=flag||dfs(nums,target-nums[idx],n,idx+1);
        }
        flag=flag||dfs(nums,target,n,idx+1);
        map.put(target,flag);
        return flag;
    }

}
