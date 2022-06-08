package lzf.DynamicProgramming;

public class Code_746 {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(new Code_746().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length==0) {
            return 0;
        }
        if (cost.length==1) {
            return cost[0];
        }
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
