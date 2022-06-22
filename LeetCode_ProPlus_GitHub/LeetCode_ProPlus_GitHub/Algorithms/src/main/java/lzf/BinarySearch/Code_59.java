package lzf.BinarySearch;

import java.util.Arrays;

public class Code_59 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(new Code_59().generateMatrix(n)));
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1, index = 1;
        while(index <= n * n){
            for(int i = left; i <= right; i++){
                res[up][i] = index++;
            }
            up++;
            for(int i = up; i <= down; i++){
                res[i][right] = index++;
            }
            right--;
            for(int i = right; i >= left; i--){
                res[down][i] = index++;
            }
            down--;
            for(int i = down; i >= up; i--){
                res[i][left] = index++;
            }
            left++;
        }
        return res;
    }
    /*public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 循环次数
        int loop = n/2;
        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;
        // 定义偏移量
        int offset = 1;
        // 定义填充数字
        int count = 1;
        // 定义中间位置
        int mid = n/2;
        while (loop >0) {
            int i = startX;
            int j = startY;

            // 模拟上侧从左到右
            for (; j<startY + n -offset; ++j) {
                res[startX][j] = count++;
            }

            // 模拟右侧从上到下
            for (; i<startX + n -offset; ++i) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;
            startX += 1;
            startY += 1;

            offset += 2;
        }
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }*/

}
