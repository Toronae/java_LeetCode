package lzf.Hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/weixin_44219664/article/details/123809478
 * 找终点 给定一个正整数数组
 */
public class Code_2_22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (canjump(nums)) {
            int steps = 0;
            int curDistance = 0;
            int nextDistance  = 0;
            for (int i = 0; i < nums.length-1; i++) {
                nextDistance = Math.max(nextDistance,i+nums[i]);
                if(nextDistance >= nums.length-1) {
                    steps++;
                    break;
                }
                if (i == curDistance){
                    curDistance = nextDistance;
                    steps++;
                }
            }
            System.out.println(steps);
        }else {
            System.out.println(-1);
        }
    }

    private static boolean canjump(int[] nums) {
        // 2 3 1 1 4
        if (nums.length ==1){
            return true;
        }
        int cover = nums[0];
        for (int i = 0; i <= cover;i++){
            cover = Math.max(cover,nums[i]+i);
            if (cover>nums.length-1){
                return true;
            }
        }
        return false;
    }
}
