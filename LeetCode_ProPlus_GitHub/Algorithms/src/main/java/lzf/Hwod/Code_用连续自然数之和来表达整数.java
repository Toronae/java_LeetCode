package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124551079?spm=1001.2014.3001.5502
 *一个整数可以由连续的自然数之和来表示。给定一个整数，计算该整数有几种连续自然数之和的表达式，且打印出每种表达式。
 * 输入描述:
 * 一个目标整数T (1 <=T<= 1000)
 * 输出描述:
 * 该整数的所有表达式和表达式的个数。如果有多种表达式，输出要求为：
 * 1.自然数个数最少的表达式优先输出
 * 2.每个表达式中按自然数递增的顺序输出，具体的格式参见样例。在每个测试数据结束时，输出一行”Result:X”，其中X是最终的表达式个数。
 * 示例1
 * 输入
 * 9
 * 输出
 * 9=9
 * 9=4+5
 * 9=2+3+4
 * Result:3
 * 说明
 * 整数 9 有三种表示方法，第1个表达式只有1个自然数，最先输出，第2个表达式有2个自然数，第2次序输出，第3个表达式有3个自然数，最后输出。每个表达式中的自然数都是按递增次序输出的。
 * 数字与符号之间无空格
 * 示例2
 * 输入
 * 10
 * 输出
 * 10=10
 * 10=1+2+3+4
 * Result:2
 */
public class Code_用连续自然数之和来表达整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int n = 1;
        while (n< sum/2){
            if (2* sum % n == 0 && (2* sum/n -n +1) %2 == 0 && (2* sum/n -n +1)/2 > 0){
                int x1 = (2* sum/n -n +1)/2;
                System.out.print(sum + "=");
                for (int i = 0; i <n ; i++) {
                    if (i == n-1){
                        System.out.print(x1++);
                    }else {
                        System.out.print(x1++ + "+");
                    }
                }
                System.out.println();
            }
            n++;
        }
    }
}
