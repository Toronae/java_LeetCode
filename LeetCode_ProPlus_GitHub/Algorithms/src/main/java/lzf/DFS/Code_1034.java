package lzf.DFS;

import java.util.Arrays;

public class Code_1034 {
    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,2}};
        int row = 0, col = 0, color = 3;
        System.out.println(Arrays.deepToString(new Code_1034().colorBorder(grid, row, col, color)));
    }

    public void dfs(int[][]grid, int x, int  y, int pre, int color, int[][]mask) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != pre) {
            return;
        }
        grid[x][y] = color;
        mask[x][y] = 1;
        dfs(grid, x - 1, y, pre ,color, mask);
        dfs(grid, x + 1, y, pre ,color, mask);
        dfs(grid, x, y - 1, pre ,color, mask);
        dfs(grid, x, y + 1, pre ,color, mask);
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid[row][col] == color) {
            return grid;
        }
        int pre = grid[row][col];
        int[][]mask = new int[grid.length][grid[0].length];
        dfs(grid, row, col, pre ,color, mask);
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (mask[i][j] == 1 && mask[i - 1][j] == 1 && mask[i + 1][j] == 1 && mask[i][j - 1] == 1 && mask[i][j + 1] == 1) {
                    grid[i][j] = pre;
                }
            }
        }
        return grid;
    }

    // dfs2
    /*boolean[][] visited;
    int init;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        visited = new boolean[grid.length][grid[0].length];//声明访问数组
        init = grid[row][col]; // 记录初始的颜色
        dfs(grid, row, col, color);
        return grid;
    }

    private void dfs(int[][] grid, int i, int j, int color) {
        //判空
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] != init) return;
        //剩下的都是未被访问过,而且值等于Init的点
        //grid[i][j]是边界
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)   grid[i][j] = color;
            //只要grid[i][j]的四周有一个不是联通分量的点,就代表它是边界
        else if (isTrue(grid, i - 1, j) || isTrue(grid, i + 1, j) || isTrue(grid, i, j - 1) || isTrue(grid, i, j + 1))
            grid[i][j] = color;
        visited[i][j] = true; //表示访问过该点
        dfs(grid, i - 1, j, color);
        dfs(grid, i, j - 1, color);
        dfs(grid, i + 1, j, color);
        dfs(grid, i, j + 1, color);
    }

    private boolean isTrue(int[][] grid, int i, int j) {
        //grid[i][j]超出范围
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        //grid[i][j]未被访问过,而且颜色与init不同
        if (grid[i][j] != init && !visited[i][j]) return true;
        //grid[i][j]被访问过,或者颜色与init相同
        return false;
    }*/
}
