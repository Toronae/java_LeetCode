package lzf.BinarySearch;

import java.util.Arrays;

public class Code_704 {
    public static void main(String[] args) {
        int[] nums ={-1,0,3,5,9,12};
        int target = 2;
        System.out.println(new Code_704().search(nums, target));
    }
    //左闭右闭
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] < target) {
                left = mid +1;
            }else if (nums[mid] > target) {
                right = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    // 左闭右开
    /*public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] < target) {
                left = mid +1;
            }else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }*/

    // 当有负数的情况，不行
    /*public int search(int[] nums, int target) {
        int result = Arrays.binarySearch(nums,target);
        return result;
    }*/
}
