package lzf.BinarySearch;

import java.util.Arrays;

public class Code_34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(new Code_34().searchRange(nums, target)));
    }

    // 二分法
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums,target);
        if (index == -1){
            return new int[]{-1,-1};
        }
        int left = index;
        int right = index;
        while (left-1 >=0 && nums[left-1] == nums[index]) {
            left--;
        }
        while (right+1 < nums.length &&nums[right+1] == nums[index]){
            right++;
        }
        return new int[]{left,right};
    }
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
    /*public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            while (left <= right && nums[left] <target){
                left++;
            }
            while (left <= right && nums[right] > target) {
                right--;
            }
            if (nums[left] == target && nums[right] ==target) {
                return new int[]{left,right};
            }else {
                break;
            }
        }
        return new int[]{-1,-1};
    }*/
}
