package lzf.PriorityQueue;

import java.util.*;

public class Code_347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(new Code_347().topKFrequent(nums, k)));
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer key:map.keySet()) {
            if (queue.size() < k){
                queue.offer(key);
            }else if (map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.offer(key);
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!queue.isEmpty()){
            res[index++] =queue.poll();
        }
        return res;
    }
}
