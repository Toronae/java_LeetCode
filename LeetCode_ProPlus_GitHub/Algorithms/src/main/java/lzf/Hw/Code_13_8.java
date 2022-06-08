package lzf.Hw;

import java.util.Arrays;

public class Code_13_8 {
    public static void main(String[] args) {
        int[][] matrix = {{1,0,0,0,1},{0,0,0,1,1},{0,1,0,1,0},{1,0,0,1,1},{1,0,1,0,1}};
        int n = 5;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += solution(matrix[i]);
        }
        System.out.println(res);
    }

    private static int solution(int[] nums) {
        int res = 0;
        String[] str = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        for (int i = 0; i < str.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str.length; j++) {
                sb.append(str[j]);
            }
            for (int k = 0; k < i; k++) {
                sb.append(str[k]);
            }
            res = Math.max(res,Integer.parseInt(sb.toString(),2));
        }
        return res;
    }
}
