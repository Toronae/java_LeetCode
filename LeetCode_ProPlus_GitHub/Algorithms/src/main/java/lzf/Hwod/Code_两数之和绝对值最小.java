package lzf.Hwod;

import java.util.Scanner;

/**
 * 给定一个从小到大的有序整数序列（存在正整数和负整数）数组 nums ，请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值，并返回这个绝对值。
 * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 输入描述:
 * 一个通过空格分割的有序整数序列字符串，最多1000个整数，且整数数值范围是 -65535~65535。
 * 输出描述:
 * 两数之和绝对值最小值
 * 示例1
 * 输入
 * -3 -1 5 7 11 15
 * 输出
 * 2
 * 说明
 * 因为 |nums[0] + nums[2]| = |-3 + 5| = 2 最小，所以返回 2
 */
public class Code_两数之和绝对值最小 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                min = Math.min(min,Math.abs(arr[i]+arr[j]));
            }
        }
        System.out.println(min);
    }
}
