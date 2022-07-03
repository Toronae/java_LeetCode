package lzf.Math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Code_313 {
    public static void main(String[] args) {
        int n = 12;
        int[] primes ={2,7,13,19};
        System.out.println(new Code_313().nthSuperUglyNumber(n,primes));
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        Set<Integer> seen = new HashSet<>();
        for(int i=1;i<n;i++){
            int cur = pq.poll();
            for(int p: primes){
                // 防止爆int处理
                if(p > Integer.MAX_VALUE / cur){
                    break;
                }
                if(!seen.contains(cur * p)){
                    seen.add(cur * p);
                    pq.add(cur * p);
                }
            }
        }
        return pq.poll();
    }
}
