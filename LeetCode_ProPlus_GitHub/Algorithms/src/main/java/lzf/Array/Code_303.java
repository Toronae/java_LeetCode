package lzf.Array;

/**
 利用一个数组preSum保存给定数组nums的前缀和，left=0,right=1的情况，就是nums[1] + nums[0],
 将这个值保存在preSum[1]中，表示从0到1的值;那么0到2的和就是preSum[1] + nums[2]，
 由此可得从0到i就是preSum[i - 1] + nums[i];
 */
public class Code_303 {
    public static void main(String[] args) {
        int[] nums ={1,5,6,7,9};
        int left = 1;
        int right = 3;
        System.out.println(new Code_303(nums).sumRange(left,right));
    }
    int[] preSum;
    public Code_303(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = nums[0];
        for(int i = 1; i <= nums.length; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
