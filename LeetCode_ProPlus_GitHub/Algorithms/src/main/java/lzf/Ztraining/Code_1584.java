package lzf.Ztraining;

import java.util.PriorityQueue;

public class Code_1584 {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(new Code_1584().minCostConnectPoints1(points));
    }

    public int minCostConnectPoints1(int[][] points) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0];
                int yi = points[i][1];
                int xj = points[j][0];
                int yj = points[j][1];
                int[] edge = new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)};
                queue.offer(edge);
            }
        }
        UF uf = new UF(n, n);
        int weight = 0;
        while (!queue.isEmpty()) {
            if (uf.count == 1) {
                return weight;
            }
            int[] edge = queue.poll();
            int x = edge[0], y = edge[1], p = edge[2];
            if (uf.isConnected(x, y)) {
                continue;
            }
            uf.union(x, y);
            weight += p;
        }
        return weight;
    }
}

class UF {
    int count;
    int[] parents;

    public UF(int count, int n) {
        this.count = n;
        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parents[rootX] = rootY;
        count--;
    }

    private int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public boolean isConnected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    public int getCount() {
        return count;
    }
}
