package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124509176?spm=1001.2014.3001.5502
 * 有一个N个整数的数组，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止，每次窗口滑动产生一个窗口和（窗口内所有数的和），求窗口滑动产生的所有窗口和的最大值。
 * 输入描述:
 * 第一行输入一个正整数N，表示整数个数。(0<N<100000)
 * 第二行输入N个整数，整数的取值范围为[-100,100]。
 * 第三行输入一个正整数M，M代表窗口大小，M<=100000，且M<=N。
 * 输出描述:
 * 窗口滑动产生的所有窗口和的最大值。
 * 示例1：
 * 输入
 * 6
 * 10 20 30 15 23 12
 * 3
 * 输出
 * 68
 * 说明
 * 窗口长度为3，窗口滑动产生的窗口和分别为10+20+30=60，20+30+15=65，30+15+23=68，15+23+12=50，所以窗口滑动产生的所有窗口和的最大值为68。
 */
public class Code_滑动窗口最大和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        int windows = Integer.parseInt(sc.nextLine());
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int left = 0;
        int right = 0;
        int total = 0;
        int max = 0;
        while (right<count){
            total += arr[right];
            if (right - left < windows){
                right++;
            }else {
                total -= arr[left];
                left++;
                right++;
            }
            max = Math.max(max,total);
        }
        System.out.println(max);
    }
}
