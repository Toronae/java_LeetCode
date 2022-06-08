package lzf.Hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/weixin_44219664/article/details/123947594
 * 九宫格按键输入法
 */
public class Code_2_23 {
    public static void main(String[] args) {
        int m = 4, n = 5, R = 5;
        int[] A = {1, 5, 5, 10};
        int[] B = {1, 3, 8, 8, 20};
        ans(A,B,m,n,R);
    }
    public static void ans(int[] A, int[] B, int m, int n, int R) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] temp = new int[2];
                if (A[i] <= B[j] && B[j] - A[i] <=R) {
                    temp[0] = A[i];
                    temp[1] = B[j];
                    res.add(temp);
                    break;
                }
            }
        }
        for (int[] output:res) {
            System.out.println(Arrays.toString(output));
        }
    }
}
