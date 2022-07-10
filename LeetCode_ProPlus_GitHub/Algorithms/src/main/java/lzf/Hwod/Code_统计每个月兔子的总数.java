package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/qq_35398517/article/details/111182687
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 输入描述:
 * 输入int型表示month
 *
 * 输出描述:
 * 输出兔子总数int型
 * 思路：
 * 规律：个数=上两个月份之和（类似爬楼梯问题）
 * 转换成公式：f(n) = f(n-1) + f(n-2)，类似爬楼梯问题
 *
 * 通过递归实现
 * 通过while循环实现
 */
public class Code_统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            System.out.println(getRabbit(a));
        }
    }

    public static int getRabbit(int month) {
        if (month <= 2) {
            return 1;
        }
        return getRabbit(month - 1) + getRabbit(month - 2);
    }

    public static int getRabbit2(int month) {
        int one = 1;
        int two = 1;
        while (month > 2) {
            two = one + two; // 记录f(n) ==> f(n) = f(n-2) + f(n-1)
            one = two - one; // 记录f(n-1) ==> f(n-1) = f(n) - f(n-2)
            month--;
        }
        return two;
    }
}
