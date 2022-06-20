package lzf.DFS;

public class Code_1905 {
    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(new Code_1905().countSubIslands(grid1,grid2));
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid1, grid2, i, j);
                    //是子岛屿才计数
                    if (flag) {
                        count++;
                    }
                    //要重置标志位
                    flag = true;
                }
            }
        }
        return count;
    }

    boolean flag = true;

    void dfs(int[][] grid1, int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        //当前遍历的grid2【陆地】在grid1中如果是【水】
        //标记为false，说明不是子岛屿，所以不计数
        if (grid1[i][j] == 0) {
            flag = false;
        }

        grid[i][j] = 0;
        dfs(grid1, grid, i - 1, j);
        dfs(grid1, grid, i + 1, j);
        dfs(grid1, grid, i, j - 1);
        dfs(grid1, grid, i, j + 1);
    }
}
