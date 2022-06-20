package lzf.BFS;

import java.util.*;

public class Code_2146 {
    public static void main(String[] args) {
        int[][] grid = {{1,2,0,1},{1,3,0,1},{0,2,5,1}};
        int[] pricing = {2,5};
        int[] start = {0,0};
        int k = 3;
        System.out.println(new Code_2146().highestRankedKItems(grid,pricing,start,k));
    }
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        // [step, price, row, col]
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            return a[3] - b[3];
        });

        LinkedList<int[]> link = new LinkedList<>();
        link.offer(start);
        vis[start[0]][start[1]] = true;

        int[] dir = new int[]{-1, 0, 1, 0, -1};
        int step = 0;
        while (!link.isEmpty()) {
            int size = link.size();
            for (int i = 0; i < size; i++) {
                int[] poll = link.poll();
                int row = poll[0], col = poll[1];
                int price = grid[row][col];
                // 无法穿越的墙
                if (price == 0) {
                    continue;
                }

                // 感兴趣的物品
                if (price >= pricing[0] && price <= pricing[1]) {
                    queue.offer(new int[]{step, price, row, col});
                }

                for (int j = 1; j < 5; j++) {
                    int nrow = row + dir[j - 1];
                    int ncol = col + dir[j];

                    if (ncol >= 0 && nrow >= 0 && nrow < m && ncol < n && !vis[nrow][ncol]) {
                        link.offer(new int[]{nrow, ncol});
                        vis[nrow][ncol] = true;
                    }
                }
            }

            step++;
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty() && ans.size() < k) {
            int[] poll = queue.poll();
            ans.add(Arrays.asList(poll[2], poll[3]));
        }

        return ans;
    }

}
