package lzf.Array;

public class Code_485 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(new Code_485().findMaxConsecutiveOnes(nums));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
             if (nums[i] != 0) {
                 count++;
             }else {
                 count = 0;
             }
             res = Math.max(count,res);
        }
        return res;
    }
}
