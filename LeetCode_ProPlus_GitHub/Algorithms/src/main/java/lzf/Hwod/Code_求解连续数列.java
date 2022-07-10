package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124528902?spm=1001.2014.3001.5502
 * 已知连续正整数数列{K}=K1,K2,K3…Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。
 * 输入描述:
 * 输入包含两个参数，1）连续正整数数列和S，2）数列里数的个数N。
 * 输出描述:
 * 如果有解输出数列K，如果无解输出-1
 * 示例1
 * 输入
 * 525 6
 * 输出
 * 85 86 87 88 89 90
 * 示例2
 * 输入
 * 3 5
 * 输出
 * -1
 */
public class Code_求解连续数列 {
    // 更优解
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int n = in.nextInt();
        // sum(x x+1 x+2 ... x+n-1) = sum
        // n*x + n*(n-1)/2 = sum
        // x= [sum - n*(n-1)/2 ]/n
        int temp = sum - n*(n-1)/2;
        if (temp <=0 || temp%n!=0){
            System.out.println(-1);
            return;
        }
        int begin = temp/n;
        for (int i = 0; i < n; i++) {
            System.out.print(begin+i);
            System.out.print(' ');
        }
    }

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int result = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);
        int middle = 0;
        if (result/count == 0){
            System.out.println(-1);
            return;
        }
        int[] arr = new int[count];
        int start = 0;
        if (result % count == 0){//count是奇数
            //正好的中间的奇数位
            middle = result/count;
            start = middle - count/2;
        }else {//向下取整了 ，middle是中间的前一个数
            middle = result/count;
            start = middle - count/2 +1;
        }
        int idx = 0;
        while (idx<count){
            arr[idx] = start;
            start++;
            idx++;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum == result){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }else {
            System.out.println(-1);
        }
    }*/
}
