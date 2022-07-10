package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124579505?spm=1001.2014.3001.5502
 * 有N个正整数组成的一个序列。给定整数sum，求长度最长的连续子序列，使他们的和等于sum，返回此子序列的长度，如果没有满足要求的序列，返回-1。
 * 输入描述:
 * 序列：1,2,3,4,2
 * sum：6
 * 输出描述:
 * 序列长度：3
 * 输入描述:
 * 序列：1,2,3,4,2
 * sum：6
 * 输出描述:
 * 序列长度：3
 * 示例1
 * 输入
 * 1,2,3,4,2
 * 6
 * 输出
 * 3
 * 说明
 * 解释：1,2,3和4,2两个序列均能满足要求，所以最长的连续序列为1,2,3，因此结果为3
 * 示例2
 * 输入
 * 1,2,3,4,2
 * 20
 * 输出
 * -1
 * 说明
 * 解释：没有满足要求的子序列，返回-1
 * 备注:
 * 输入序列仅由数字和英文逗号构成，数字之间采用英文逗号分隔；
 * 序列长度：1 <= N <= 200；
 * 输入序列不考虑异常情况，由题目保证输入序列满足要求。
 */
public class Code_最长连续子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int[] arr = new int[split.length];
        int sum = Integer.parseInt(sc.nextLine());
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
            total += arr[i];
        }
        if (total< sum){
            System.out.println(-1);
        }else if (total == sum){
            System.out.println(split.length);
        }else {
            //双指针
            int left = 0;
            int right = 0;
            int temp = 0;
            while (left < arr.length && right< arr.length){
                if (temp < sum){
                    temp += arr[right];
                    right++;
                }else if (temp != sum){
                    temp -= arr[left];
                    left++;
                }
                if (temp == sum) {
                    System.out.println(right - left);
                    left++;
                    right = left;
                    temp = 0;
                }
            }
        }
    }
}
