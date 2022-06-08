package lzf.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Code_200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new Code_200().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.offer(new int[]{i,j});
        while (!list.isEmpty()) {
            int[] cur = list.poll();
            i = cur[0];
            j = cur[1];
            if (0 <= i && i< grid.length && 0 <=j && j< grid[0].length &&grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[]{i+1,j});
                list.add(new int[]{i-1,j});
                list.add(new int[]{i,j+1});
                list.add(new int[]{i,j-1});
            }
        }
    }
}
