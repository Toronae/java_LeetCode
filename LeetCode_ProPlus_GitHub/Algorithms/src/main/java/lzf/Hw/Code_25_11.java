package lzf.Hw;

public class Code_25_11 {
    public static void main(String[] args) {
        int[] nums = {1,3,1,4,0};
        int k = 2;
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i]<2){
                count++;
            }
        }
        int left = 0 ,rigth = count, res = Integer.MAX_VALUE;

        while (rigth < n) {
            int temp = 0;
            for (int i = left; i < rigth; i++) {
                if (nums[i]<k){
                    temp++;
                }
            }
            res = Math.min(res,count-temp);
            left++;
            rigth++;
        }
        System.out.println(res);
    }
}
