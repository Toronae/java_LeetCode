package lzf.DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code_377 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int target = 4;
        System.out.println(new Code_377().combinationSum4(nums,target));
    }
    private Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int ans=0;
        return dfs(nums,target,n);
    }
    public int dfs(int nums[],int target,int n){
        if(target==0) {
            return 1;
        }
        if(target<0) {
            return 0;
        }
        if(map.containsKey(target)) {
            return map.get(target);
        }
        int ret=0;
        for(int i=0;i<n;i++){
            if(target-nums[i]>=0){
                ret+=dfs(nums,target-nums[i],n);
            }
        }
        map.put(target,ret);
        return ret;
    }
    // 方法二
    int[] memo;
    public int combinationSum41(int[] nums, int target) {
        memo=new int[target+1];
        Arrays.fill(memo,-1);
        return dfs(nums,target);
    }

    private int dfs(int[] nums, int target) {
        int sum=0;
        //目标值为0，表示找到一组可能的组合
        if(target==0){
            return 1;
        }
        //目标值小于0，说明当前尝试失败
        if(target<0){
            return 0;
        }
        //表示当前target的所有可能组合被计算过，就可以直接使用，即剪枝
        if (memo[target] != -1) {
            return memo[target];
        }
        for (int i = 0; i < nums.length; i++) {
            sum+=dfs(nums,target-nums[i]);
            //dfs(nums,target-nums[i])  调用一次这个函数，就表示对当前target的一种组合探索，要么探索返回1，表示找到一种组合，要么返回0
            //表示没找到，  然后用sum累加所有 对target组合能找到的情况 ，就是数组中元素能组合成target的所有可能
        }
        memo[target]=sum;
        return sum;
    }

    //递归
    public int combinationSum42(int[] nums, int target) {
        int ans = 0;

        if(target == 0) {
            return 1;
        }

        for(int num : nums) {
            if(target >= num) {
                ans += combinationSum4(nums, target - num);
            }
        }
        return ans;
    }
}
