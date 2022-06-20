package lzf.BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS常用来处理最短路径问题，或可达性问题
 * 对于两个小岛之间的最短路径，自然想到要用广度优先搜索来查找
 * 可以先找到其中一片岛屿，运用DFS把它标识为2，与另一片岛屿进行区分，也防止重复遍历
 * 在1的标识过程中，收集第一片岛屿附近的海洋（最近一层的海洋0），加入队列queue
 * BFS搜索队列，逐层往外“填海造陆”，直到遇到第二片岛屿
 */
public class Code_934 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.println(new Code_934().shortestBridge(grid));
    }
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        // 记录下来整个图的尺寸
        int n = grid.length, m = grid[0].length;
        // 标记哪些位置已经访问过了
        boolean[][] visited = new boolean[n][m];
        // 标记是否找到第一个小岛了
        boolean findIsland = false;
        // 记录第一个小岛的边界
        Queue<int[]> board = new LinkedList<>();
        // 去标记第一个小岛，将原来的 1 改成 2
        for (int x = 0; x < n && !findIsland; ++x) {
            for (int y = 0; y < m && !findIsland; ++y) {
                if (!visited[x][y] && grid[x][y] == 1) {
                    mark(grid, visited, x, y, 2, board);
                    findIsland = true;
                }
            }
        }
        // 记录距离
        int ans = 0;
        while (!board.isEmpty()) {
            // 记录当前需要遍历的边界数量
            int size = board.size();
            for (int i = 0; i < size; ++i) {
                // 取出来下一个要检查的坐标
                int[] next = board.poll();
                for (int j = 0; j < 4; ++j) {
                    // 对这个坐标进行上下左右检查
                    assert next != null;
                    int nx = next[0] + dirs[j][0];
                    int ny = next[1] + dirs[j][1];
                    // 如果这个新坐标合法，而且没有访问过，就对其进行检查
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                        // 首先标记成访问过了
                        visited[nx][ny] = true;
                        // 如果接触到了第二个小岛，那么直接返回距离计数器 ans
                        if (grid[nx][ny] == 1) {
                            return ans;
                        }else {
                            // 否则的话，就放到边界队列中
                            board.add(new int[]{nx, ny});

                        }
                    }
                }
            }
            // 边界计数器加一
            ++ans;
        }
        return ans;
    }

    /**
     * 对 grid 中的一个小岛进行标记
     * @param grid      小岛描述图
     * @param visited   标记某个坐标是否访问过了
     * @param x         出发点 [x, y]
     * @param y         出发点 [x, y]
     * @param color     要标记成的颜色
     * @param board     用来保存边界的队列
     */
    private void mark(int[][] grid, boolean[][] visited, int x, int y, int color, Queue<int[]> board) {
        grid[x][y] = color;
        // 判断是不是边界，是的话就直接放到队列中
        if (x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1 ||
                grid[x + 1][y] == 0 || grid[x - 1][y] == 0 || grid[x][y + 1] == 0 || grid[x][y - 1] == 0) {
            board.add(new int[]{x, y});
        }
        // 对 [x, y] 上下左右四个方向进行拓展检查
        for (int i = 0; i < 4; ++i) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            // 对小岛进行扩展查找
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny] && grid[nx][ny] == 1) {
                visited[nx][ny] = true;
                mark(grid, visited, nx, ny, color, board);
            }
        }
    }

    /*int INF = 205;
    int[] dy = new int[]{-1, 1, 0, 0};
    int[] dx = new int[]{0, 0, -1, 1};
    Deque<int[]> queue = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean b = false;
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    DFS(i, j, grid);
                    b = true;
                    break;
                }
            }
            if(b) break;
        }
        int result = 0;
        while (!queue.isEmpty()){
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int y = temp[0]+dy[k];
                    int x = temp[1]+dx[k];
                    if(y>=0 && y< grid.length && x>=0 && x < grid.length && grid[y][x]!=2){
                        if(grid[y][x]==0){
                            queue.add(new int[]{y, x});
                            grid[y][x] = 2;
                        }else if(grid[y][x]==1){
                            return result-1;
                        }
                    }
                }
            }
        }
        return result;
    }
    public void DFS(int i, int j, int[][] grid){
        queue.add(new int[]{i, j});
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            int y = i+dy[k];
            int x = j+dx[k];
            if(y>=0 && y< grid.length && x>=0 && x < grid.length && grid[y][x]==1){
                DFS(y, x, grid);
            }
        }
    }*/


}
