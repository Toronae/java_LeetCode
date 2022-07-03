package lzf.Hw;

/**
 * https://blog.csdn.net/weixin_44219664/article/details/123809235
 */
public class Code_25_17 {
    public static void main(String[] args) {
        int[] nums = {10,9,8,7,6,5,4,3,2,1};
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int width = Math.abs(nums[i]-nums[j]);
                int height = Math.min(nums[i], nums[j]);
                res = Math.max(res,width*height);
            }
        }
        System.out.println(res);
    }
}
