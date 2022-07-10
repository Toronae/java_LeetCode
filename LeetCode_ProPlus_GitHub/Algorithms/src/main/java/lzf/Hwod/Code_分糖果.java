package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124390802?spm=1001.2014.3001.5502
 * 小明从糖果盒中随意抓一把糖果，每次小明会取出一半的糖果分给同学们。
 * 当糖果不能平均分配时，小明可以选择从糖果盒中（假设盒中糖果足够）取出一个糖果或放回一个糖果。
 * 小明最少需要多少次（取出、放回和平均分配均记一次），能将手中糖果分至只剩一颗
 * 输入描述:
 * 抓取的糖果数（<10000000000）：
 * 15
 * 输出描述:
 * 最少分至一颗糖果的次数：
 * 5
 * 示例1：
 * 输入
 * 15
 * 输出
 * 5
 * 备注:
 * 解释：(1)15+1=16;(2)16/2=8;(3)8/2=4;(4)4/2=2;(5)2/2=1;
 */
public class Code_分糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(handle(num));

    }
    private static int handle(int tang){
        if (tang == 1){
            return 0;
        }
        if (tang % 2 == 0){
            tang /= 2;
            //次数+1
            return handle(tang)+1;
        }
        int plus = handle(tang +1) +1;//增加一个
        int sub = handle(tang -1) +1;//减少一个
        return Math.min(plus,sub);
    }
}
