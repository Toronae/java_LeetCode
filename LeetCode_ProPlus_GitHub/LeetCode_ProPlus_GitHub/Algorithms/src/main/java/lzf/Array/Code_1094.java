package lzf.Array;

import java.util.*;

public class Code_1094 {
    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 4;
        System.out.println(new Code_1094().carPooling(trips,capacity));
    }

    // 哈希表
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trip:trips) {
            int current = trip[0];
            int start = trip[1];
            int end = trip[2];
            for (int i = start; i < end; i++) {
                map.put(i,map.getOrDefault(i,0)+current);
                if (map.get(i) >capacity){
                    return false;
                }
            }
        }
        return true;
    }

    // 差分数组
    /*public boolean carPooling(int[][] trips, int capacity) {
        int[] sites = new int[1001];
        for (int[] trip:trips) {
            // 上车加
            sites[trip[1]] += trip[0];
            // 下车减
            sites[trip[2]] -= trip[0];
        }
        int total = 0;
        for (int i:sites) {
            total += i;
            if (total > capacity) {
                return false;
            }
        }
        return true;
    }*/

    /*public boolean carPooling(int[][] trips, int capacity) {
        //创建一个以下车顺序的小根堆
        PriorityQueue<int[]> heap=new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        //对上车顺序排序
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        for (int[] trip : trips) {
            //先上车
            capacity -= trip[0];
            //车位不够就下车
            if (capacity < 0) {
                while (!heap.isEmpty() && heap.peek()[2] <= trip[1]) capacity += heap.poll()[0];//能下的都下完
                if (capacity < 0) return false;//能下完的 下完还不行就返回
            }
            //加到堆里面
            heap.offer(trip);
        }
        return true;
    }*/
}
