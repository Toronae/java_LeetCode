package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124544351?spm=1001.2014.3001.5502
 * 所谓水仙花数，是指一个n位的正整数，其各位数字的n次方和等于该数本身。例如153是水仙花数，153是一个3位数，并且153 = 111 + 555 + 333
 * 输入描述:
 * 第一行输入一个整数n，表示一个n位的正整数。n在3到7之间，包含3和7。[3,7]
 * 第二行输入一个正整数m，表示需要返回第m个水仙花数。
 * 输出描述:
 * 返回长度是n的第m个水仙花数。个数从0开始编号。
 * 若m大于水仙花数的个数，返回最后一个水仙花数和m的乘积。
 * 若输入不合法，返回-1。
 * 示例1
 * 输入
 * 3 0
 * 输出
 * 153
 * 说明
 * 153是第一个水仙花数
 * 示例2
 * 输入
 * 9
 * 1
 * 输出
 * -1
 * 说明
 * 9超出范围
 */
public class Code_水仙花数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());//[3,7]
        int num = Integer.parseInt(sc.nextLine());
        if (count< 3 || count> 7){
            System.out.println(-1);
            return;
        }//3 100 4 1000
        int start = 1;
        for (int i = 1; i < count; i++) {
            start *= 10;
        }
        int end = start *10 -1;
        int times = 0;
        for (int i = start; i < end; i++) {
            if (checkFlower(i)){
                if (times++ == num) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean checkFlower(int num){
        int temp = num;
        int total = 0;
        while (temp > 0){
            int wei = temp%10;
            total += wei *wei * wei;
            temp /=10;
        }
        return total == num;
    }
}
