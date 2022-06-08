package lzf.Two_Pointers;

import java.util.Arrays;

public class Code_167 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,4};
        int target = 6;
        System.out.println(Arrays.toString(new Code_167().twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right =numbers.length-1;
        int[] index = new int[2];
        while (numbers[left] + numbers[right] != target){
            if ( numbers[left] + numbers[right] > target ){
                right--;
            }else {
                left++;
            }
        }
        index[0] = left+1;
        index[1] = right+1;
        return index;
    }

    //暴力破解法
    /*public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        for (int i = 0; i < numbers.length ; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i]+numbers[j] == target) {
                    index[0] = i+1;
                    index[1] = j+1;
                    return index;
                }
            }
        }
        return null;
    }*/
}
