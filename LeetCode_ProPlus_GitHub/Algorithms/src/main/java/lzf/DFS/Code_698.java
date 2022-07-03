package lzf.DFS;

import java.util.Arrays;

/***
 * 递归——相当于一条路，走到黑，不撞南墙不回头.
 * 回溯——返回上一个状态（通常都在递归结束后）.
 */
public class Code_698 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(new Code_698().canPartitionKSubsets(nums,k));
    }

    int[] bucket;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true; //如果k是1，直接返回true。
        }
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            // 算出nums的总和。
            sum += num;
        }
        if (sum % k != 0) {
            //子集分不出k份，直接false。
            return false;
        }
        sum /= k;// sum变为每个子集的和。
        Arrays.sort(nums);
        /*
            为什么要排序呢，其实不排序这道题也能做对，但是由于时间的关系就t了。
            排序就是为了优化时间，怎么优化呢？
            我们从nums中最大的数开始找，如果最大的数比子集和都要大，或者装下它后没到子集和的大小但是装不下nums中最小的值了，
            那么这个nums绝对是false，因为有一个这么大的数在nums里，你把它放在哪个子集里都不合适。
        */
        bucket = new int[k];//这个数组里放的是子集和，总共有k个。相当于k个桶，元素一个一个往里面放。
        Arrays.fill(bucket, sum);
        return dfs(k, nums, len - 1);
    }

    public boolean dfs(int k, int[] nums, int cur) {//cur为当前的位置，从最后开始往前走。
        if (cur < 0) {
            // cur走到-1时，说明所有的数全部都放进桶里了。这时一定是true
            return true;
        }
        for (int i = 0; i < k; i++) {
            //两种可能，这个数正好是桶当前的容量，或者将这个数放进桶后这个桶还能再放别的数。
            if (bucket[i] == nums[cur] || bucket[i] - nums[cur] >= nums[0]) {
                //将cur放进第一个桶里，如果不行，拿出来再放进第二个桶里。
                //区别就是如果cur放进第一个桶，那么下一个数如果符合也会放在第一个桶，可是最后发现是false，那么可能我应该把这两个数分开来放。
                bucket[i] -= nums[cur];
                if (dfs(k, nums, cur - 1)) {
                    return true;
                }
                bucket[i] += nums[cur];
            }
        }
        return false;
    }
    //这里讨论一种问题，为什么只要判断cur<0就能说明true，而不需要判断一下bucket数组中的值是否全部都是0。
    /*
        有没有可能bucket数组中的数有剩余但是cur已经小于0了呢？答案是不可能。
        因为如果cur<0,那么说明nums中的所有数全部都放进去了，如果全部都放进去，bucket中的数尽管可能不全为0，但是数组中的和一定是0。
        因为bucket的和与nums的和是一样的，所以我用nums中的数在不重复的状态下去减bucket中的数，全部减去的情况下bucket中的和一定是0。
        可是真的可能有负数吗，第26行我们的if条件严格判断如果没有一个桶内剩余的空间能放下这个数的话是不会执行递归的，只会返回一个false,
        因此cur一旦有一个递归没下去cur就不可能为-1，只能换其他的情况再去试。
    */


    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum=0;
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(sum%k!=0){
            return false;
        }
        int target=sum/k;
        if(nums[nums.length-1]>target){
            return false;
        }
        return dfs(nums,nums.length-1,target,0,k,used);
    }

    public static boolean dfs(int[] nums,int begin,int target,int curSum,int k,boolean[] used)
    {
        //剪枝1
        if(k==1){
            return true;
        }
        if(curSum==target){
            //找到了一个组合,还有k-1个.
            return dfs(nums,nums.length-1,target,0,k-1,used);}
        //剪枝4
        for(int i=begin;i>=0;i--)
        {
            //使用过的元素就不能再使用了
            if(used[i]){
                continue;
            }
            //剪枝2
            if(curSum+nums[i]>target){
                continue;
            }
            //添加元素nums[i]
            used[i]=true;
            if(dfs(nums,i-1,target,curSum+nums[i],k,used)) {
                return true;
                //如果添加这个元素后，完成了题目要求，就return true.
            }
            //回溯
            used[i]=false;
            //剪枝3
            while(i>0&&nums[i-1]==nums[i]){
                i--;
            }

        }
        return false;
    }
}
