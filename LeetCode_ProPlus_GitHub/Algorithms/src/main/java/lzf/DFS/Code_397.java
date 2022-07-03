package lzf.DFS;

import java.util.HashMap;
import java.util.Map;

public class Code_397 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(new Code_397().integerReplacement(n));
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }
        else if(n == Integer.MAX_VALUE){
            return 32;
        }
        else if(map.containsKey(n)) {
            return map.get(n);
        }
        if(n % 2 == 0){
            int res = integerReplacement(n / 2) + 1;
            map.put(n, res);
            return res;
        }else{
            int res=  Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
            map.put(n, res);
            return res;
        }
    }
}
