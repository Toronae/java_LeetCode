package lzf.DynamicProgramming;

/**
 * 完全背包
 * 爬楼梯
 */
public class Code_70 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Code_70().climbStairs(n));
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /*public int climbStairs(int n) {
        // 跟斐波那契数列一样
        if(n <= 2) return n;
        int a = 1, b = 2, sum = 0;

        for(int i = 3; i <= n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }*/
}
