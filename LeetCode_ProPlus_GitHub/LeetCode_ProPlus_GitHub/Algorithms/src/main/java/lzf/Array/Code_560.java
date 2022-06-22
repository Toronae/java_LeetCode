package lzf.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 */
public class Code_560 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int k = 5;
        System.out.println(new Code_560().subarraySum(nums, k));
    }

    // hash表

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0,ret = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)){
                ret += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ret;
    }
    // 前缀和
    /*public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i+1] = preSum[i]+nums[i];
        }
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                if (preSum[right+1] - preSum[left] ==k) {
                    count++;
                }
            }
        }
        return count;
    }*/

    // 暴力破解

    /*public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;
            for (int right = left; right < len; right++) {
                sum +=nums[right];
                if (sum ==k) {
                    count++;
                }
            }
        }
        return count;
    }*/
}
