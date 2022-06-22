package lzf.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Code_1254 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(new Code_1254().closedIsland(grid));
    }
    private int[][] DIRECTIONS = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int rows;
    private int cols;

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (bfs(grid, visited, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean bfs(int[][] grid, boolean[][] visited, int startx, int starty) {
        boolean res = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startx, starty});
        visited[startx][starty] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == 0 || cur[1] == 0 || cur[0] == rows - 1 || cur[1] == cols - 1) {
                res = false;
            }
            for (int[] d : DIRECTIONS) {
                int newx = cur[0] + d[0];
                int newy = cur[1] + d[1];
                if (newx >= 0 && newx < rows && newy >=0 && newy < cols && grid[newx][newy] == 0 && !visited[newx][newy]) {
                    queue.offer(new int[]{newx,newy});
                    visited[newx][newy] = true;

                }
            }
        }
        return res;
    }

}
