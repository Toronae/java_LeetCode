package lzf.BFS;

import java.util.*;
import java.util.stream.Collectors;

public class Code_433 {
    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(new Code_433().minMutation(start,end,bank));
    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> cnt = new HashSet<>(Arrays.asList(bank));
        // visited记录已经遍历过的基因序列，避免重复
        Set<String>  visited = new HashSet<>();
        char[] keys = {'A','C','G','T'};
        if (start.equals(end)) {
            return 0;
        }
        if (!cnt.contains(end)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != curr.charAt(j)) {
                            StringBuilder sb = new StringBuilder(curr);
                            sb.setCharAt(j,keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                if (next.equals(end)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    //
   /* private static final char[] CHARS = {'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        if(start.compareTo(end) == 0)
            return 0;
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(start);
        int step = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int l = 0; l < len; l++) {
                String cur = queue.pollFirst();
                for(int i = 0; i < cur.length(); i++) {
                    char c = cur.charAt(i);
                    for(char nxtChar: CHARS) {
                        if(nxtChar != c) {
                            String nxt = cur.substring(0, i) + nxtChar + cur.substring(i + 1);
                            if(bankSet.contains(nxt)) {
                                if(nxt.compareTo(end) == 0)
                                    return step + 1;
                                bankSet.remove(nxt);
                                queue.addLast(nxt);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }*/

}
