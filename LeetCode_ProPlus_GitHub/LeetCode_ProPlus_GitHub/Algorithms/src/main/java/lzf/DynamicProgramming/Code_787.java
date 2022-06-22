package lzf.DynamicProgramming;

import java.util.*;
import java.util.stream.IntStream;

public class Code_787 {

    // 动态规划 dp[i][k]表示从 i点到 dst 走 k 步的最少价格
    int INF = 1000007;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return dp(n, flights, src, dst, k);
    }

    private int dp(int n, int[][] flights, int src, int dst, int K) {
        // dp[i][k]表示从i点到dst走k步的最少价格
        // dp[i][k]=min(dp[i_next][k-1] + g[i][j])
        int[][] dp = new int[n][K+2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[dst][0] = 0;
        for (int k = 1; k <= K + 1; k++) {
            for (int[] flight : flights) {
                dp[flight[0]][k] = Math.min(dp[flight[0]][k], dp[flight[1]][k - 1] + flight[2]);
            }
        }

        int ans = IntStream.of(dp[src]).min().getAsInt();

        return ans >= INF ? -1 : ans;
    }


    // 记忆化搜索
    /*int INF = 1000007;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // k表示经过的节点，我们转成边数（步数），这样好计算一些
        int[][] memo = new int[n][k+2];
        int ans = dfs(flights, src, dst, k + 1, memo);
        return ans >= INF ? -1 : ans;
    }

    // 表示从 i 到 dst 的走 k 步的最小价格
    private int dfs(int[][] flights, int i, int dst, int k, int[][] memo) {
        if (k < 0) {
            return INF;
        }

        if (i == dst) {
            return 0;
        }

        if (memo[i][k] != 0) {
            return memo[i][k];
        }

        int min = INF;
        for (int[] flight : flights) {
            // 遍历 i 的下一个节点
            if (flight[0] == i) {
                min = Math.min(min, dfs(flights, flight[1], dst, k - 1, memo) + flight[2]);
            }
        }

        memo[i][k] = min;

        return min;
    }*/

    // BFS + 剪枝
    /*int INF = 1000007;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return bfs(n, flights, src, dst, k);
    }

    private int bfs(int n, int[][] flights, int src, int dst, int k) {
        // 整理题目给定的flights，转换成每个节点的子节点有哪些
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            g[flight[0]].add(new int[] {flight[1], flight[2]});
        }

        // 表示src到i到最小价格
        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});
        // 退出条件加上 k 的限制
        while (!queue.isEmpty() && k + 1 > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] path : g[poll[0]]) {
                    int distance = poll[1] + path[1];
                    // 剪枝1，小于 i 之前记录的最小值，且小于 dst 之前记录的最小值
                    if (distance < ans[path[0]] && distance < ans[dst]) {
                        ans[path[0]] = distance;
                        // 剪枝2，到 dst 了就不用继续往下了
                        if (path[0] != dst) {
                            queue.offer(new int[] {path[0], distance});
                        }
                    }
                }
            }
            k--;
        }

        return ans[dst] >= INF ? -1 : ans[dst];
    }*/

}
