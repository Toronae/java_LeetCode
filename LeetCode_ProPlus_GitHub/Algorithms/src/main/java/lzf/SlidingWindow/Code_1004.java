package lzf.SlidingWindow;

public class Code_1004 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(new Code_1004().longestOnes(nums,k));
    }
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        while(right<n){
            if(nums[right]==0){
                count++;
            }
            right++;
            while(count>k){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
