package lzf.BinarySearch;

public class Code_162 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Code_162().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;
        if(n == 1){
            return 0;
        }

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(mid > 0 && mid < n - 1  && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid == 0 && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid == n - 1 && nums[mid- 1] < nums[mid]){
                return mid;
            }

            if(mid < n - 1 && nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }
}
