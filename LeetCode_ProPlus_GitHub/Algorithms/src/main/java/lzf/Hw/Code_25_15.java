package lzf.Hw;

import java.util.LinkedList;
import java.util.Queue;

public class Code_25_15 {
    public static void main(String[] args) {
        int[][] nums = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(new Code_25_15().solution(nums));
    }

    public int solution(int[][] nums) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = nums.length, m = nums[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }else {
                    count++;
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()&&count>0) {
            res++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] temp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = temp[0] + dirs[j][0];
                    int newY = temp[1] + dirs[j][1];
                    if (newX>=0 && newX< n && newY>=0 && newY<m && !visited[newX][newY]) {
                        queue.add(new int[]{newX,newY});
                        visited[newX][newY] = true;
                        count--;
                    }
                }
            }
        }
        if (count>0){
            return 0;
        }else {
            return res;
        }
    }
}
