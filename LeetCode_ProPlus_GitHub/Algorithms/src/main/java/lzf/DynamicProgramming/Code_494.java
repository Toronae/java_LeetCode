package lzf.DynamicProgramming;

/**
 * 01背包
 */
public class Code_494 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(new Code_494().findTargetSumWays(nums,target));
    }
    //dp[j] 表示：填满j（包括j）这么大容积的包，有dp[i]种方法
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int size = (target + sum) / 2;
        if(size < 0) {
            size = -size;
        }
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
    //回溯法
    int res=0;
    public int findTargetSumWays1(int[] nums, int target) {
        backTrack(nums,target,0,0);
        return res;

    }
    public void backTrack(int[]nums,int target,int depth,int sum){
        if(depth==nums.length){
            if(sum==target) {
                res++;
            }
            return;

        }
        for(int i=-1;i<2;i=i+2){
            int k=i*nums[depth];
            sum=sum+k;
            //  System.out.println(sum);
            backTrack(nums,target,depth+1,sum);
            sum=sum-k;
        }
    }
}
