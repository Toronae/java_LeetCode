package lzf.Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Code_239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new Code_239().maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length<2) {
            return nums;
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length+1-k];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.add(i);
            if (queue.peek() <= i-k){
                queue.poll();
            }
            if (i+1 >= k) {
                res[i+1-k] = nums[queue.peek()];
            }
        }
        return res;
    }
}
