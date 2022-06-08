package lzf.Queue;

import java.util.Deque;
import java.util.LinkedList;

public class Code_862 {
    public static void main(String[] args) {
        int[] nums = {2,-1,2};
        int k = 4;
        System.out.println(new Code_862().shortestSubarray(nums,k));
    }
    public int shortestSubarray(int[] nums, int k) {
        long[]arr=new long[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            arr[i]=arr[i-1]+(long)nums[i-1];
        }
        Deque<Integer> deque=new LinkedList<>();
        int res=nums.length+1;
        for(int i=0;i<=nums.length;i++){
            while(!deque.isEmpty()&&arr[i]<=arr[deque.peekLast()]){
                deque.pollLast();
            }
            while(!deque.isEmpty()&&arr[i]-arr[deque.peekFirst()]>=k){
                res=Math.min(res,i-deque.pollFirst());
            }
            deque.addLast(i);
        }
        return res<nums.length+1?res:-1;
    }
}
