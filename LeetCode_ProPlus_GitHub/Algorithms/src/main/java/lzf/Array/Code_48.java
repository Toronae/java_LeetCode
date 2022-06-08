package lzf.Array;

import java.util.Arrays;

public class Code_48 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Code_48 code = new Code_48();
        code.rotate(matrix);
    }
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len/2; i++) {
            int start = i;
            int end = len - i-1;
            for (int j = 0; j < end-start; j++) {
                int temp = matrix[start][start+j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = temp;
                System.out.println(Arrays.deepToString(matrix));
            }
        }
    }


    // 动态规划
    /*public void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][len-i-1] = matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(temp));
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }*/
}
