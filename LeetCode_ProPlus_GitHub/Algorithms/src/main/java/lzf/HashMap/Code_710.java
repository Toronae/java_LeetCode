package lzf.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Code_710 {
    public static void main(String[] args) {

    }
    int size;
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();
    public Code_710(int n, int[] blacklist) {
        size = n- blacklist.length;
        for (int black:blacklist) {
            map.put(black,666);
        }
        int last = n-1;
        for (int black:blacklist) {
            if (black >=size){
                continue;
            }
            while (map.containsKey(last)){
                last--;
            }
            map.put(black,last);
            last--;
        }
    }

    public int pick() {
        int k = random.nextInt(size);
        return map.getOrDefault(k,k);
    }
}
