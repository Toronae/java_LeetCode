package lzf.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Code_962 {
    public static void main(String[] args) {
        int[] nums = {6,0,8,2,1,5};
        System.out.println(new Code_962().maxWidthRamp(nums));
    }
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            if(stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int res = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                res = Math.max(res,i - stack.pop());
            }
        }

        return res;
    }
}
