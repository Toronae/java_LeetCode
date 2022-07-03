package lzf.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code_1631 {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(new Code_1631().minimumEffortPath(heights));
    }
    public int minimumEffortPath(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    edges.add(new int[] {
                            Math.abs(mat[i][j + 1] - mat[i][j]),
                            i * N + j,
                            i * N + j + 1
                    });
                }
                if (i + 1 < M) {
                    edges.add(new int[] {
                            Math.abs(mat[i + 1][j] - mat[i][j]),
                            i * N + j,
                            (i + 1) * N + j
                    });
                }
            }
        }
        Collections.sort(edges, (o1, o2) -> o1[0] - o2[0]);

        UnionFind5 uf = new UnionFind5(M * N);
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if (uf.find(0) == uf.find(M * N - 1)) {
                return edge[0];
            }
        }
        return 0;
    }
}
class UnionFind5 {
    int count;      // 连通分量个数
    int[] parent;   // 节点i的父节点是parent[i]

    public UnionFind5(int N) {
        this.count = N;         // n为图的节点总数
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            // 父节点指针初始指向自己
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;          // x成为y的子树
        count--;
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
