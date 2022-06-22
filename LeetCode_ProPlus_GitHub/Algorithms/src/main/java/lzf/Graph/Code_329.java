package lzf.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Code_329 {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(new Code_329().longestIncreasingPath(matrix));
    }
    //bfs
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        // 从每个点出发，看它能扩散多远
        int m = matrix.length;
        int n = matrix[0].length;

        // BFS开始，需要将所有节点都加入初始队列
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queue.offer(new int[] {i, j});
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            // 内层循环表示一次处理一批，这一批都是相同路径长度的
            int size = queue.size();
            for (int c = 0; c < size; c++) {
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                for (int[] dir : dirs) {
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];
                    // 看上下左右有没有比自己大的，有则加入队列，下一批处理
                    if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ <n && matrix[nextI][nextJ] > matrix[i][j]) {
                        queue.offer(new int[] {nextI, nextJ});
                    }
                }
            }
        }

        return ans;
    }

    //拓扑排序
    /*int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        // 把符合题目要求的点连起来就是有一张有向无环图
        // 所以我们可以使用多源BFS拓扑排序寻找最短路径的思想在这里寻找最长路径
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录每个节点的出度
        int[][] outDegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];
                    // 只要旁边节点的值比它大，它的出度就加1
                    if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && matrix[nextI][nextJ] > matrix[i][j]) {
                        outDegree[i][j]++;
                    }
                }
            }
        }

        // 多源BFS（可以跟上面的循环合在一起）
        // 为了更清晰，这里单独写这个循环
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (outDegree[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            // 一次遍历一批，每遍历一批，相当于最长路径又加了一
            int size = queue.size();
            for (int c = 0; c < size; c++) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];
                for (int[] dir : dirs) {
                    int preI = i + dir[0];
                    int preJ = j + dir[1];
                    if (preI >= 0 && preI < m && preJ >= 0 && preJ < n && matrix[preI][preJ] < matrix[i][j]) {
                        // 指向当前元素的节点的出度减1，减到0了入队
                        if (--outDegree[preI][preJ] == 0) {
                            queue.offer(new int[] {preI, preJ});
                        }
                    }
                }
            }
        }

        return ans;
    }*/

    //记忆化搜索
    /*int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        // 从每一个点出发，往下深搜，看它最远能到哪
        int m = matrix.length;
        int n = matrix[0].length;

        // 记忆化
        int[][] memo = new int[m][n];

        // 每个点都要作为起始点遍历一下
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 已经遍历过的就不用遍历了
                if (memo[i][j] == 0) {
                    ans = Math.max(ans, dfs(matrix, m, n, i, j, memo));
                }
                // 这里为什么不用再比较一次 ans 和 memo[i][j]呢？
                // 因为遍历前面节点的时候已经把后面的节点遍历了
                // 说明后面的节点肯定比前面的节点的最长路径短
                // 所以，不用多判断一次了
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] memo) {
        // 已经遍历过，直接返回
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // 否则，看四个方向是否有满足条件的节点去扩散
        // 每个节点的初始路径为1
        int ans = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ <n && matrix[nextI][nextJ] > matrix[i][j]) {
                ans = Math.max(ans, dfs(matrix, m, n, nextI, nextJ, memo) + 1);
            }
        }

        // 记录到缓存中
        memo[i][j] = ans;
        return ans;
    }*/

}
