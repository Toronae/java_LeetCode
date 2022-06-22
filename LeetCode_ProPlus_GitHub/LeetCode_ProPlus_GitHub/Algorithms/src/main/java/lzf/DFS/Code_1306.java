package lzf.DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Code_1306 {
    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(new Code_1306().canReach(arr,start));
    }
    //dfs
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return dfs(arr, start, n, visited);
    }
    public boolean dfs(int[] num, int idx, int n, boolean[] visited) {
        if (idx < 0 || idx >= num.length || visited[idx]) {
            return false;
        }
        if (num[idx] == 0) {
            return true;
        }
        int step = num[idx];
        visited[idx] = true;
        return dfs(num, idx + step, n, visited) || dfs(num, idx - step, n, visited);
    }

    //bfs
    public boolean canReach1(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur < 0 || cur >= arr.length) {
                    continue;
                }
                if (visited[cur]) {
                    continue;
                }
                if (arr[cur] == 0) {
                    return true;
                }
                visited[cur] = true;
                q.offer(cur + arr[cur]);
                q.offer(cur - arr[cur]);
            }
        }
        return false;
    }
}
