package lzf.Array;

public class Code_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Code_283().moveZeroes(nums);
    }
    // 双指针法
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=0) {
                if (index < i) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
    /*public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }*/
}
