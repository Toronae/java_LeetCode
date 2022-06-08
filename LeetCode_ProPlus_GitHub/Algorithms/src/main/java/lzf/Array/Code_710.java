package lzf.Array;

import java.util.*;

public class Code_710 {
    public static void main(String[] args) {
        int n = 7;
        int[] b = {2,3,5};
        System.out.println(new Code_710(n, b).pick());
    }

    Map<Integer, Integer> m;
    Random r;
    int wlen;

    public Code_710(int n, int[] b) {
        m = new HashMap<>();
        r = new Random();
        wlen = n - b.length;
        Set<Integer> w = new HashSet<>();
        for (int i = wlen; i < n; i++) {
            w.add(i);
        }
        for (int x : b) {
            w.remove(x);
        }
        Iterator<Integer> wi = w.iterator();
        for (int x : b){
            if (x < wlen){
                m.put(x, wi.next());
            }
        }
    }

    public int pick() {
        int k = r.nextInt(wlen);
        return m.getOrDefault(k, k);
    }


    /*List<Integer> w;
    Random r;

    public Code_710(int n, int[] blacklist) {
        w = new ArrayList<>();
        r = new Random();
        Set<Integer> W = new HashSet<>();
        for (int i = 0; i < n; i++) {
            W.add(i);
        }
        for (int x : blacklist) {
            W.remove(x);
        }
        for (int x : W) {
            w.add(x);
        }
    }

    public int pick() {
        return w.get(r.nextInt(w.size()));
    }*/



    /*int size;
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
    }*/
}
