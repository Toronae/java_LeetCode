package lzf.BinarySearch;

public class Code_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(new Code_35().searchInsert(nums,target));
    }

    // 二分法
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        // 定义target在左闭右闭的区间
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = low + (high-low)/2;
            if (nums[mid] >target) {
                high = mid-1;
            }else if (nums[mid] < target) {
                low = mid+1;
            }else {
                return mid;
            }
        }
        return high+1;
    }

    /*public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }*/
}
