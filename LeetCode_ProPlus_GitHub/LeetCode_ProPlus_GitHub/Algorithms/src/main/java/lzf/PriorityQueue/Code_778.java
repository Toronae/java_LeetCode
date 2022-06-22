package lzf.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_778 {
    public static void main(String[] args) {
        int[][] grid = {{0,2},{1,3}};
        System.out.println(new Code_778().swimInWater(grid));
    }
    public int swimInWater(int[][] grid) {
        int m = grid.length,n=grid[0].length,ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(a->grid[a[0]][a[1]]));
        boolean[][] used = new boolean[m][n];
        pq.add(new int[]{0,0});
        used[0][0] = true;
        while (!pq.isEmpty()){
            int[] p = pq.poll();
            ans = Math.max(ans,grid[p[0]][p[1]]);
            if (p[0] == m-1 && p[1] == n-1){
                return ans;
            }
            for (int[] d: new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int x = p[0] + d[0], y = p[1] + d[1];
                if (x < 0 || y < 0 || x >= m || y >= n || used[x][y]) {
                    continue;
                }
                pq.add(new int[]{x, y});
                used[x][y] = true;
            }
        }
        return -1;
    }
}
