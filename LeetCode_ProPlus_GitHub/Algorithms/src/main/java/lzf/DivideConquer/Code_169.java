package lzf.DivideConquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code_169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new Code_169().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            temp.put(nums[i], temp.getOrDefault(nums[i],0)+1);
        // System.out.println(temp);
        }
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            if (entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/

}
