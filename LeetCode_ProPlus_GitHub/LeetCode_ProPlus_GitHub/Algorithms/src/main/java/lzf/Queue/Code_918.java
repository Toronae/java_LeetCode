package lzf.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Code_918 {
    public static void main(String[] args) {
        int[] nums ={1,-2,3,-2};
        System.out.println(new Code_918().maxSubarraySumCircular(nums));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int N = nums.length;
        int[] P = new int[2*N+1];
        for (int i = 0; i < 2*N; ++i){
            P[i+1] = P[i] + nums[i % N];
        }

        int ans = nums[0];
        Deque<Integer> deque = new ArrayDeque();
        deque.offer(0);
        for (int j = 1; j <= 2*N; ++j) {
            if (deque.peekFirst() < j-N){
                deque.pollFirst();
            }
            ans = Math.max(ans, P[j] - P[deque.peekFirst()]);
            while (!deque.isEmpty() && P[j] <= P[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(j);
        }
        return ans;
    }
}
