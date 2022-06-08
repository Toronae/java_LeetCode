package lzf.Queue;

import java.util.Arrays;
import java.util.LinkedList;

public class Code_2071 {
    public static void main(String[] args) {
        int[] tasks = {3,2,1};
        int[] workers = {0,3,3};
        int pills = 1;
        int strength = 1;
        System.out.println(new Code_2071().maxTaskAssign(tasks,workers,pills,strength));
    }
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        LinkedList<Integer> que = new LinkedList<>();
        int left = 0, right = Math.min(n, m), ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int cnt = pills;
            int index = m - 1;
            que.clear();
            boolean flag = true;
            for (int i = mid - 1; i >= 0 && flag; i--) {
                int task = tasks[i];
                while (index >= m - mid && workers[index] + strength >= task) {
                    que.addFirst(workers[index--]);
                }
                if (que.isEmpty()) {
                    flag = false;
                } else if (que.getLast() >= task) {
                    que.removeLast();
                } else {
                    if (cnt <= 0) {
                        flag = false;
                    } else {
                        que.removeFirst();
                        cnt--;
                    }
                }
            }

            if (flag) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
