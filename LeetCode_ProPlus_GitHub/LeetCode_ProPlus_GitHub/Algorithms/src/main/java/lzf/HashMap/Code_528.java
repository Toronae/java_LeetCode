package lzf.HashMap;

import java.util.Arrays;

public class Code_528 {
    public static void main(String[] args) {

    }
    int[] pre;
    int total;
    public Code_528(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i-1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int x = (int) ((Math.random()*total)+1);
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int low =0;
        int high =pre.length-1;
        while(low <=high){
            int mid = low + (high-low)/2;
            if (pre[mid] <x){
                low = mid +1;
            }else {
                high = mid-1;
            }
        }
        return low;
    }
}
