package lzf.PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Code_451 {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(new Code_451().frequencySort(s));
    }
    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> items = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        items.addAll(count.entrySet());
        StringBuilder res = new StringBuilder();
        while(!items.isEmpty()){
            Map.Entry<Character, Integer> item = items.poll();
            char key = item.getKey();
            int val = item.getValue();
            for(int i = 0; i < val; i++){
                res.append(key);
            }
        }
        return res.toString();
    }
}
