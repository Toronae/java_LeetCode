package lzf.Math;

import java.util.PriorityQueue;

public class Code_313 {
    public static void main(String[] args) {
        int n = 12;
        int[] primes ={2,7,13,19};
        System.out.println(new Code_313().nthSuperUglyNumber(n,primes));
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) {
                return x;
            }
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) {
                    q.add(k * x);
                }
                if (x % k == 0) {
                    break;
                }
            }
        }
        return -1;
    }
}
