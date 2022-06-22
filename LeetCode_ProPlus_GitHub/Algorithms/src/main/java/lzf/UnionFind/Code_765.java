package lzf.UnionFind;

public class Code_765 {
    public static void main(String[] args) {
        int[] row = {0,2,1,3};
        System.out.println(new Code_765().minSwapsCouples(row));
    }
    int[] p = new int[70];
    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }
    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public int minSwapsCouples(int[] row) {
        int n = row.length, m = n / 2;
        for (int i = 0; i < m; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (i == find(i)) {
                cnt++;
            }
        }
        return m - cnt;
    }
}
