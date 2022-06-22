package lzf.DFS;

import java.util.ArrayList;
import java.util.List;

public class Code_417 {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(new Code_417().pacificAtlantic(heights));
    }
    int n, m;
    int[][] g;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        g = heights;
        m = g.length; n = g[0].length;
        boolean[][] res1 = new boolean[m][n], res2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (!res1[i][j]){
                        dfs(i, j, res1);
                    }
                }
                if (i == m - 1 || j == n - 1) {
                    if (!res2[i][j]) {
                        dfs(i, j, res2);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res1[i][j] && res2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    void dfs(int x, int y, boolean[][] res) {
        res[x][y] = true;
        for (int[] di : dirs) {
            int nx = x + di[0], ny = y + di[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (res[nx][ny] || g[nx][ny] < g[x][y]) {
                continue;
            }
            dfs(nx, ny, res);
        }
    }


}
