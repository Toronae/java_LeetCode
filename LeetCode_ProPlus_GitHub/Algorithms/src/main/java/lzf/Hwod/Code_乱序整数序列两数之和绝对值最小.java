package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124643796?spm=1001.2014.3001.5502
 * 给定一个随机的整数（可能存在正整数和负整数）数组 nums ，请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值，并返回这个两个数（按从小到大返回）以及绝对值。
 * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 输入描述:
 * 一个通过空格分割的有序整数序列字符串，最多1000个整数，且整数数值范围是 [-65535, 65535]。
 * 输出描述:
 * 两数之和绝对值最小值
 * 示例1
 * 输入
 * -1 -3 7 5 11 15
 * 输出
 * -3 5 2
 * 说明
 * 因为 |nums[0] + nums[2]| = |-3 + 5| = 2 最小，所以返回 -3 5 2
 */
public class Code_乱序整数序列两数之和绝对值最小 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        int res = Integer.MAX_VALUE;
        int l1 = Integer.MIN_VALUE;
        int l2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int temp = Math.abs(arr[i] + arr[j]);
                if (temp < res){
                    l1 = arr[i];
                    l2 = arr[j];
                    res = temp;
                }
            }
        }
        if (l1>l2){
            int temp = l2;
            l2 = l1;
            l1 = temp;
        }
        System.out.println(l1 +" " + l2 + " " + res);
    }
}
