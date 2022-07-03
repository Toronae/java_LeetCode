package lzf.DivideConquer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

public class Code_215 {
    public static void main(String[] args) throws ScriptException {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new Code_215().findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /*public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }*/

    public int findKthLargest1(int[] nums, int k) {
        //优先级队列，就是个小根堆
        //固定优先级队列的长度为k,那么最后留在优先级队列里面的数就是最大的k个数。
        PriorityQueue<Integer> minTree = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            //每个数都加入到小根堆中。
            minTree.add(nums[i]);
            //如果加入之后堆的大小 大于k，那么就弹出堆顶。
            //这样的话每次加入之后最大的都在下面，弹出的都是小的数。
            if (minTree.size() > k){
                minTree.poll();
            }
        }
        //堆顶的数就是第k大的。
        return minTree.peek();
    }
}
