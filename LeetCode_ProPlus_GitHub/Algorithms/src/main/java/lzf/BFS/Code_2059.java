package lzf.BFS;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 双向 BFS
 */
public class Code_2059 {
    public static void main(String[] args) {

    }
    int[] nums;
    public int minimumOperations(int[] _nums, int s, int t) {
        nums = _nums;
        Deque<Long> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        Map<Long, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.addLast(s * 1L);
        d2.addLast(t * 1L);
        m1.put(s * 1L, 0);
        m2.put(t * 1L, 0);
        while (!d1.isEmpty() && !d2.isEmpty()) {
            if (d1.size() < d2.size()) {
                int ans = update(d1, m1, d2, m2, true);
                if (ans != -1) {
                    return ans;
                }
            } else {
                int ans = update(d2, m2, d1, m1, false);
                if (ans != -1) {
                    return ans;
                }
            }
        }
        return -1;
    }
    int update(Deque<Long> d1, Map<Long, Integer> m1, Deque<Long> d2, Map<Long, Integer> m2, boolean flag) {
        long cur = d1.pollFirst();
        int step = m1.get(cur);
        for (int i : nums) {
            if (flag) {
                // 正向搜索：进行出队检查，只有出队元素符合条件，才能使用出队元素往下拓展
                if (0 <= cur && cur <= 1000) {
                    long[] result = new long[]{cur + i, cur - i, cur ^ i};
                    for (long next : result) {
                        if (m2.containsKey(next)) {
                            return step + 1 + m2.get(next);
                        }
                        if (!m1.containsKey(next)) {
                            d1.addLast(next);
                            m1.put(next, step + 1);
                        }
                    }
                }
            } else {
                // 反向搜索：进行入队检查，只有拓展元素符合条件，才能将拓展元素入队
                long[] result = new long[]{cur + i, cur - i, cur ^ i};
                for (long next : result) {
                    if (0 <= next && next <= 1000) {
                        if (m2.containsKey(next)) {
                            return step + 1 + m2.get(next);
                        }
                        if (!m1.containsKey(next)) {
                            d1.addLast(next);
                            m1.put(next, step + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
