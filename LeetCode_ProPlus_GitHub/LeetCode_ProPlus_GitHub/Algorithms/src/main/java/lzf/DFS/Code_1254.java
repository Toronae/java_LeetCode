package lzf.DFS;

public class Code_1254 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(new Code_1254().closedIsland(grid));
    }
    public int closedIsland(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        //先将与边界相连的岛屿去除
        for(int i=0;i<m;i++){
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        for(int j=0;j<n;j++){
            dfs(grid,0,j);
            dfs(grid,m-1,j);
        }
        //再统计剩余岛屿数量
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans+=dfs(grid,i,j);
            }
        }
        return ans;
    }
    int dfs(int[][] grid,int row,int col){
        int m=grid.length,n=grid[0].length;
        //陆地是0，水域是1
        if(row<0||row>=m||col<0||col>=n||grid[row][col]==1) {
            return 0;
        }
        grid[row][col]=1;
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
        return 1;
    }


    /*private int val;
    public int closedIsland(int[][] grid) {
        int closedLandNum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    val = 1;
                    dfs(grid, i, j);
                    closedLandNum += val;
                }
            }
        }
        return closedLandNum;
    }
    public void dfs(int[][] grid, int i, int j){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length){
            val = 0;
            return;
        }
        if(grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }*/


    /*int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // DFS
    public int closedIsland(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        if (M == 1 && N == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0 || i == M - 1 || j == N - 1) {
                    continue;
                }
                if (grid[i][j] == 0) { // 从不在四个边上的每个陆地出发，进行一次DFS
                    if (dfs(grid, i, j, M, N)) {
                        res++; // 如果DFS结果是封闭的，就计数
                    }
                }
            }
        }
        return res;
    }
    // 返回值含义：是否是封闭岛屿
    private boolean dfs(int[][] grid, int i, int j, int M, int N) {
        // 出现越界，说明不是封闭岛屿，返回false
        if (i < 0 || j < 0 || i == M || j == N) {
            return false;
        }
        boolean res = true;
        if (grid[i][j] == 0) { // 如果是陆地进行DFS
            grid[i][j] = 1; // 将陆地改成水，替代visited数组
            for (int[] dir : dirs) { // 四个方向深搜, 有一个方向越界就不是封闭的
                // 这里必须要将四个方向都跑完，不能遇到一个为false就返回
                if (!dfs(grid, i + dir[0], j + dir[1], M, N)) {
                    res = false;
                }
            }
        }
        return res;
    }*/

}
