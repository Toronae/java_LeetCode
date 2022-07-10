package lzf.Hw;

/**
 * 分糖果，分积木
 * https://blog.csdn.net/qq_40016949/article/details/113762549
 */
public class Code_25_19 {
    public static void main(String[] args) {
        int[] nums = {3,5,6};
        System.out.println(solution(nums));
    }

    private static String solution(int[] nums) {
        if (nums.length ==0 || nums.length==1){
            return "NO";
        }
        if(nums.length == 2 && nums[0] != nums[1]){
            return "NO";
        }
        int min = nums[0];
        int sum = min;
        int temp = min;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min,nums[i]);
            temp ^= nums[i];
        }
        if (temp!=0){
            return "NO";
        }else {
            return String.valueOf(sum-min);
        }
    }
}
