package lzf.DynamicProgramming;

public class Code_209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(new Code_209().minSubArrayLen(target,nums));
    }
    // dp
    private int maxCount = Integer.MAX_VALUE;
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] h = new int[n];

        int j = 0, sum = 0;
        int q = maxCount;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum < s) {
                h[i] = maxCount;
            } else {
                while (sum - nums[j] >= s) {
                    sum -= nums[j];
                    j++;
                }
                h[i] = i - j + 1;
            }
            q = Math.min(q, h[i]);
        }

        return q != maxCount ? q : 0;
    }

}
