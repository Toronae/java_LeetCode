package lzf.PriorityQueue;

import java.util.PriorityQueue;

public class Code_407 {
    public static void main(String[] args) {
        int[][] heights = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(new Code_407().trapRainWater(heights));
    }
    int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
    public int trapRainWater(int[][] heights) {
        int res =0, M = heights.length, N = heights[0].length;
        boolean[][] visited = new boolean[M][N];
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((o1, o2) -> o1[2]-o2[2]);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(i == 0 || i == M-1 || j == 0 || j==N -1){
                    minHeap.offer(new int[]{i,j,heights[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        while(!minHeap.isEmpty()){
            int[] point = minHeap.poll();
            int curMin = point[2];
            for (int[] dir:dirs) {
                int i = point[0] + dir[0],j = point[1] + dir[1];
                if (i >=0 && i< M && j >=0 &&j<N &&!visited[i][j]){
                    if (curMin > heights[i][j]){
                        res += curMin -heights[i][j];
                        heights[i][j] = curMin;
                    }
                    minHeap.offer(new int[]{i,j,heights[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        return res;
    }



    /*int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    // BFS + 小根堆 木桶原理 一圈一圈的，由外围向内包抄，由农村包围城市的革命道路
    public int trapRainWater(int[][] heights) {
        int res = 0, M = heights.length, N = heights[0].length;
        boolean[][] visited = new boolean[M][N];  // 标记访问数组
        // 小根堆 存放坐标和高度 [i, j, h] 按高度排序
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        // 先把最外边一圈放入小根堆队列
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == M - 1 || j == 0 || j == N - 1) {
                    minHeap.offer(new int[]{i, j, heights[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        // 从最外层一圈开始向内进行BFS搜索能灌水的格子
        while (!minHeap.isEmpty()) {
            int[] point = minHeap.poll(); // 取出堆顶当前最小值
            int curMin = point[2];
            for (int[] dir : dirs) { // 看一下四个邻居的格子，能不能往里灌水
                int i = point[0] + dir[0], j = point[1] + dir[1];
                if (i >= 0 && i < M && j >= 0 && j < N && !visited[i][j]) {
                    // 如果邻居格子比当前的格子矮，说明能往邻居家里灌水
                    if (curMin > heights[i][j]) {
                        res += curMin - heights[i][j]; // 累加灌水水量(高度差)
                        heights[i][j] = curMin; // 将邻居家灌满水
                    }
                    minHeap.offer(new int[]{i, j, heights[i][j]}); // 邻居入队
                    visited[i][j] = true; //标记已访问
                }
            }
        }
        return res;
    }*/

    /*public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int m = heights[0].length;
        // 用一个vis数组来标记这个位置有没有被访问过
        boolean[][] vis = new boolean[n][m];
        // 优先队列中存放三元组 [x,y,h] 坐标和高度
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        // 先把最外一圈放进去
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.offer(new int[]{i, j, heights[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        // 方向数组，把dx和dy压缩成一维来做
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            // 看一下周围四个方向，没访问过的话能不能往里灌水
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dirs[k];
                int ny = poll[1] + dirs[k + 1];
                // 如果位置合法且没访问过
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                    if (poll[2] > heights[nx][ny]) {
                        res += poll[2] - heights[nx][ny];
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    pq.offer(new int[]{nx, ny, Math.max(heights[nx][ny], poll[2])});
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }*/

}
