package lzf.Ztraining;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Code_239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new Code_239().maxSlidingWindow(nums, k)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length<2){
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.add(i);
            if (deque.peek()<= i-k){
                deque.poll();
            }
            if (i+1>=k){
                res[i+1-k] = nums[deque.peek()];
            }
        }
        return res;
    }
}
