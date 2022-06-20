package lzf.BFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Code_994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new Code_994().orangesRotting(grid));
    }
    //bfs
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //四个方向移动
        int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };

        // count 表示新鲜橘子的数量
        int count = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    //腐烂的入队
                    queue.add(new int[]{r, c});
                }
            }
        }

        // round 表示分钟数
        int round = 0;
        //注意条件 count不能少，否则会多计算
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                int[] tmp = queue.poll();
                for(int k = 0; k < 4; k++) {
                    int cr = tmp[0] + dir[k][0];
                    int cc = tmp[1] + dir[k][1];
                    if(cr >= 0 && cr < M && cc >= 0 && cc < N && grid[cr][cc] == 1) {
                        //开始腐烂
                        grid[cr][cc] = 2;
                        count--;
                        //添加新元素
                        queue.add(new int[]{cr, cc});
                    }
                }
            }
        }
        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
    // bfs 2
    public int orangesRotting1(int[][] grid) {
        // 第一感觉用广度优先遍历
        int m = grid.length, n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0; // 用来记录新鲜橘子的个数
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // 先找出所有的腐烂橘子入队
                } else if (grid[i][j] == 1) {
                    count++; // 新鲜橘子+1
                }
            }
        }
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        int round = 0; // 用来记录遍历的层数或轮数或橘子腐烂的时间
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int p = 0; p < size; ++p) {
                int[] temp = queue.poll();
                int x = temp[0], y = temp[1];
                for (int k = 0; k < 4; ++k) {
                    int i = x + dx[k], j = y + dy[k];
                    // 如果在边界内且某个方向有新鲜橘子，则遍历
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2; // 新鲜橘子 变为腐烂橘子
                        count--; // 新鲜橘子腐烂掉 相应减少新鲜橘子
                        queue.offer(new int[]{i, j}); // 腐烂橘子入队
                    }
                }
            }
        }
        // 在能腐烂的新鲜橘子都腐烂后，如果count还大于0，说明有新鲜橘子没法腐烂 则返回-1
        return count > 0 ? -1 : round;
    }

    //bfs
    /*public int orangesRotting(int[][] grid) {
        int[] p1 = {1, -1, 0, 0}, p2 = {0, 0, 1, -1};
        Deque<int[]> queue = new ArrayDeque<>();
        //把腐烂的🍊加入队列中，作为开始扩散的起点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        //从腐烂的🍊开始感染，其实就是一个bfs求无权图最短路的问题
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int j = 0; j < p1.length; j++) {
                    int x = temp[0] + p1[j], y = temp[1] + p2[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
            if (!queue.isEmpty()) {
                steps++;
            }
        }

        //遍历矩阵，判断是否有🍊还未被感染，也就是是否还有grid[i][j] = 1的地儿
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return steps;
    }*/

    //dfs
    /*int[][] grid;
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dfs(i, j, 2); // 开始传染
                }
            }
        }

        // 经过dfs后，grid数组中记录了每个橘子被传染时的路径长度，找出最大的长度即为腐烂全部橘子所用的时间。
        int maxLevel = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1; // 若有新鲜橘子未被传染到，直接返回-1
                } else {
                    maxLevel = Math.max(maxLevel, grid[i][j]);
                }
            }
        }

        return maxLevel == 0? 0: maxLevel - 2;
    }

    private void dfs(int i, int j, int level) { // level用来记录传染路径的长度（当然最后要减2）
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ) {
            return;
        }
        if (grid[i][j] != 1 && grid[i][j] < level) { // 只有新鲜橘子或者传播路径比当前路径长的橘子，才继续进行传播。
            return;
        }

        grid[i][j] = level; // 将传染路径的长度存到grid[i][j]中
        level++;
        dfs(i - 1, j, level);
        dfs(i + 1, j, level);
        dfs(i, j - 1, level);
        dfs(i, j + 1, level);
    }*/
}
