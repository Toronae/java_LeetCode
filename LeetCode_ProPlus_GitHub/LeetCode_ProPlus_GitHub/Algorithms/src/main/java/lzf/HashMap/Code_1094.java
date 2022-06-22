package lzf.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Code_1094 {
    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 4;
        System.out.println(new Code_1094().carPooling(trips,capacity));
    }
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
}
