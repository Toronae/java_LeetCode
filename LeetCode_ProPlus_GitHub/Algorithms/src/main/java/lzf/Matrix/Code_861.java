package lzf.Matrix;

public class Code_861 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(new Code_861().matrixScore(grid));
    }
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            // 如果第 i 行以 0 开头
            if (grid[i][0] == 0) {
                // 行翻转
                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            // 统计第 j 列有多少个 1。
            for (int i = 0; i < m; i++) {
                cnt += grid[i][j];
            }
            // max(cnt, m - cnt) 表示这个位置最多有多少个 1。 1<<(n-j-1) 表示这个位置的1的大小。
            result += Math.max(cnt, m - cnt) * (1 << (n - j - 1));
        }
        return result;
    }
}
