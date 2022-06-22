package lzf.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_1353 {
    public static void main(String[] args) {
        int[][] events = {{1,2},{2,3},{3,4}};
        System.out.println(new Code_1353().maxEvents(events));
    }
    public int maxEvents(int[][] events) {
        int n = events.length;
        // 按照开始时间升序排列，这样，对于相同开始时间的会议，可以一起处理
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 小顶堆：用于高效的维护最小的 endDay
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int currDay = 1;
        int i = 0;
        while (i < n || !pq.isEmpty()) {
            // 将所有开始时间等于 currDay 的会议的结束时间放到小顶堆
            while (i < n && events[i][0] == currDay) {
                pq.add(events[i][1]);
                i++;
            }

            // 将已经结束的会议弹出堆中，即堆顶的结束时间小于 currDay 的
            while (!pq.isEmpty() && pq.peek() < currDay) {
                pq.remove();
            }

            // 贪心的选择结束时间最小的会议参加
            if (!pq.isEmpty()) {
                // 参加的会议，就从堆中删除
                pq.remove();
                res++;
            }

            // 当前的天往前走一天，开始看下下一天能不能参加会议
            currDay++;
        }

        return res;
    }
}
