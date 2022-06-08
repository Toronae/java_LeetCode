package lzf.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new Code_215().findKthLargest(nums,k));
    }
    public int findKthLargest(int[] nums, int k) {
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
    //
    /*public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        // Java 里没有 heapify ，因此我们逐个将前 k 个元素添加到 minHeap 里
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topElement = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topElement) {
                // Java 没有 replace()，所以得先 poll() 出来，然后再放回去
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }*/
}
