package lzf.DynamicProgramming;

public class Code_931 {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(new Code_931().minFallingPathSum(matrix));
    }
    public int minFallingPathSum(int[][] matrix) {
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
    }
}
