package lzf.Array;

import java.util.HashSet;
import java.util.Set;

public class Code_26 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,5,7,7};
        System.out.println(new Code_26().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != nums[index]){
                nums[index+1] = nums[i];
                index++;
            }
        }
        return index+1;
    }

    // hashset法
    /*public int removeDuplicates(int[] nums) {
        Set result = new HashSet();
        for (int i = 0; i < nums.length;i++){
            result.add(nums[i]);
            System.out.println(result);
        }
        return result.size();
    }*/
}
