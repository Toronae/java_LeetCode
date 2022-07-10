package lzf.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Dijkstra , floyd
 * 743,1514,1631
 */
public class Code_743 {
    public static void main(String[] args) {

    }
    /*
   Floyd+邻接矩阵 O(N^3):
   枚举中间边+枚举起点+枚举终点 -> 松弛操作
    */
    int N = 105;    // 节点数
    int[][] w = new int[N][N]; // 邻接矩阵(权重图)
    int INF = 0x3f3f3f3f;   // 大数用于初始化
    int n;
    public int networkDelayTime(int[][] times, int _n, int k) {
        n = _n;
        // 初始化权重
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // w[i] [i]为0,其余为INF
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        // 载入times的数据
        for (int[] t : times) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }
        floyd();
        // 找出从k出发到达任意点的最短路径的最大值
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, w[k][i]);
        }
        // 没有被更新证明找不到任意点的最短路
        return res == INF ? -1 : res;
    }

    private void floyd() {
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 直接用w矩阵进行计算:i->p + p->j = i->j
                    w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                }
            }
        }
    }

    //Dijkstra
    public int networkDelayTime1(int[][] times, int n, int k) {
        int max = 0x3f3f3f3f;
        List<int[]>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<int[]>();
        }

        for (int[] x : times) {
            int a = x[0], b = x[1], c = x[2];
            g[a].add(new int[]{b, c});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        heap.add(new int[]{0, k});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, max);
        boolean[] v = new boolean[n + 1];
        dist[k] = 0;

        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int distance = poll[0], t = poll[1];
            // 一个点可能被多次更新, 堆中可能有多个相同的点, 只需要用该点更新一次其他店即可
            if (v[t]) {
                continue;
            }
            v[t] = true;

            for (int[] x : g[t]) {
                int a = x[0], w = x[1];
                if (dist[a] > distance + w) {
                    dist[a] = distance + w;
                    heap.add(new int[]{dist[a], a});
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                return -1;
            }
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
