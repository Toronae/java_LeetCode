package lzf.DynamicProgramming;

/**
 *  下降路径最小和
 */
public class Code_931 {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(new Code_931().minFallingPathSum(matrix));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = n-2; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = matrix[i+1][j];
                if (j > 0){
                    best = Math.min(best, matrix[i+1][j-1]);
                }
                if (j+1 < n){
                    best = Math.min(best, matrix[i+1][j+1]);
                }
                matrix[i][j] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: matrix[0]){
            ans = Math.min(ans, x);
        }
        return ans;
    }

    //回溯
    private int n;
    public int minFallingPathSum1(int[][] matrix) {
        this.n = matrix.length;
        int ans = Integer.MAX_VALUE;
        // 从第一行的每一个位置开始搜索
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, backtrack(matrix, 0, i));
        }
        return ans;
    }
    private int backtrack(int[][] matrix, int row, int col) {
        // 结束条件：到达最后一行 (和 N 皇后很像)
        if (row == n) {
            return 0;
        }
        // 向正下方遍历
        int path = backtrack(matrix, row + 1, col);
        if (col - 1 >= 0) {
            // 向左下方遍历
            path = Math.min(path, backtrack(matrix, row + 1, col - 1));
        }
        if (col + 1 < n) {
            // 向右下方遍历
            path = Math.min(path, backtrack(matrix, row + 1, col + 1));
        }
        // path 为子问题的最小值
        // 返回 path + 加上当前值
        // 和「树的后序遍历」➕「分解子问题的思路」很像
        return path + matrix[row][col];
    }
    /*public int minFallingPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int[] dp = new int[m+2];
        dp[0] = 10001;//由题确定边界最大值为10000，10001不会越界
        dp[m+1] = dp[0];
        for (int i = 0; i < m; i++) {
            dp[i+1] = matrix[0][i];
        }
        int temp = 0 ;
        for (int i = 1; i < m; i++) {
            temp = dp[0];
            for (int j = 0; j < m; j++) {
                int cur = dp[j+1];
                int x = matrix[i][j];
                dp[j+1] = Math.min(dp[j+1]+x,Math.min(temp+x,dp[j+2]+x));
                temp = cur;
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=m;i++){
            res = Math.min(res,dp[i]);
        }
        return res;
    }*/

}
