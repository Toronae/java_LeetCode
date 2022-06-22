package lzf.Graph;

public class Code_997 {
    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1,2}};
        System.out.println(new Code_997().findJudge(n,trust));
    }
    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0], y = edge[1];
            ++inDegrees[y];
            ++outDegrees[x];
        }
        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
