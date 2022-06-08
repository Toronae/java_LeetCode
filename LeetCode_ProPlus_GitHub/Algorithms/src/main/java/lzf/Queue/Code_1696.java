package lzf.Queue;

import java.util.LinkedList;

public class Code_1696 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-2,4,-7,3};
        int k = 2;
        System.out.println(new Code_1696().maxResult(nums,k));
    }

    public int maxResult(int[] nums , int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if( i==0 ){
                queue.offerLast(i);
                continue;
            }
            nums[i] += nums[ queue.peekFirst()];
            while (queue.size()> 0 && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while (i - queue.peekFirst() >=k){
                queue.pollFirst();
            }
        }
        return nums[queue.pollLast()];
    }
}

