package lzf.SlidingWindow;

public class Code_1493 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(new Code_1493().longestSubarray(nums));
    }
    public int longestSubarray(int[] nums) {
        if(nums.length==1) {
            return 0;
        }
        int res=0; //保存结果
        //定义循环不变量[left..right] ：区间 0 的个数不超过1
        int left=0,right=0;
        int count=0; //记录窗口内0的个数
        while(right<nums.length){
            if(nums[right]==0) {
                ++count;
            }
            while(count>1){  //0的个数超过1，收缩左窗口
                if(nums[left]==0) {
                    --count;
                }
                ++left;
            }
            res=Math.max(res,right-left); //删之前窗口内元素个数right-left+1，再删掉一个元素
            ++right;
        }
        return res;
    }
}
