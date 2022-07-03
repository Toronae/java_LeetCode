package lzf.DynamicProgramming;

/**
 * 总共有多少条不同的路径（有障碍物版）
 */
public class Code_63 {
    public static void main(String[] args) {
        int[][] obstacleGrid= new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new Code_63().uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            ////一旦遇到障碍，后续都到不了
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            ////一旦遇到障碍，后续都到不了
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
