package lzf.Hw;

/**
 * 配出最小绝对值
 * https://blog.csdn.net/weixin_47243236/article/details/122741674
 */
public class Code_25_6 {
    public static void main(String[] args) {
        int[] nums = {-1,-3,7,5,11,15};
        int res = Integer.MAX_VALUE;
        int n = 0, m = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                int temp = Math.abs(nums[i]+nums[j]);
                if (temp < res) {
                    res = temp;
                    n = nums[i];
                    m = nums[j];
                }
            }
        }
        System.out.println(n+" "+m+" "+res);
    }
}
