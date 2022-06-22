package lzf.Hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_25_3 {
    public static void main(String[] args) {
        int[][] matrix = {{0,30},{5,10},{15,20}};
        System.out.println(range(matrix));
    }

    private static int range(int[][] matrix) {
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(matrix[0][1]);
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(matrix[i][1]);
        }
        return queue.size();
    }
}
