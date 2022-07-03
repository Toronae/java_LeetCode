package lzf.BFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 多源 BFS
 */
public class Code_1162 {
    public static void main(String[] args) {

    }
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    d.add(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }
        int ans = -1;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!d.isEmpty()) {
            int[] poll = d.poll();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            for (int[] di : dirs) {
                int nx = dx + di[0], ny = dy + di[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (grid[nx][ny] != 0) {
                    continue;
                }
                grid[nx][ny] = step + 1;
                d.add(new int[]{nx, ny});
                map.put(nx * n + ny, step + 1);
                ans = Math.max(ans, step + 1);
            }
        }
        return ans;
    }
}
