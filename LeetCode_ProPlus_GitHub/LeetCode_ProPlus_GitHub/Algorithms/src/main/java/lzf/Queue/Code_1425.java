package lzf.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Code_1425 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,2,-10,5,20};
        int k = 2;
        System.out.println(new Code_1425().constrainedSubsetSum(nums,k));
    }
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            if (!deque.isEmpty() && (i-deque.peek() > k )) {
                deque.poll();
            }
            if (!deque.isEmpty()) {
                sum[i] += sum[deque.peek()];
            }
            while (!deque.isEmpty() && sum[i] >= sum[deque.peekLast()]) {
                deque.pollLast();
            }
            if (sum[i] > 0) {
                deque.addLast(i);
            }
            res = Math.max(res,sum[i]);
        }
        return res;
    }

}
