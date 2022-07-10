package lzf.Hwod;

import java.util.Scanner;

/**
 * http://dl2.kerwin.cn:8063/csdn/key/article-qq_34465338-125035196/auth/1657361600-2022110618131967-0-8e6437692bf1007aaf56ff2bdc12b9f3
 * 给定一个含有N个正整数的数组, 求出有多少个连续区间（包括单个正整数）, 它们的和大于等于x。
 * 输入描述:
 * 第一行两个整数N x（0 < N <= 100000, 0 <= x <= 10000000)
 * 第二行有N个正整数（每个正整数小于等于100)。
 * 输出描述:
 * 输出一个整数，表示所求的个数。
 * 示例1
 * 输入
 * 3 7
 * 3 4 7
 * 输出
 * 4
 * 说明
 * 3+4 4+7 3+4+7 7这四组数据都是大于等于7的，所以答案为4
 * 示例2
 * 输入
 * 10 10000000
 * 1 2 3 4 5 6 7 8 9 10
 * 输出
 * 0
 * 解题思路：
 * 因为都是正整数，所以只要前面的数字和满足条件了，则后面所有的数字组合都满足
 */
public class Code_数组连续和 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] ints = new int[n];

        for(int i=0;i<n;i++){
            ints[i] = sc.nextInt();
        }

        int count;  //连续正数和
        int res = 0;

        for(int i=0;i<n;i++){
            count = ints[i];    //当前数字
            /**
             * 因为是正整数，所以如果当前数字符合要求
             * 则由此往后的连续和都符合要求
             * 连续区间数为长度n-当前数字下标i
             */
            if(count>=x){
                res+=n-i;
                continue;
            }
            for (int j=i+1;j<n;j++){
                count+=ints[j];
                if(count>=x){
                    res+=n-j;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
