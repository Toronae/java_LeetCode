package lzf.Hwod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124558394?spm=1001.2014.3001.5502
 * 给定两个整数数组array1、array2，数组元素按升序排列。假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值
 * 注意：两对元素如果对应于array1、array2中的两个下标均相同，则视为同一对元素。
 * 输入描述:
 * 输入两行数组array1、array2，每行首个数字为数组大小size(0 < size <= 100);
 * 0 < array1[i] <= 1000
 * 0 < array2[i] <= 1000
 * 接下来一行为正整数k
 * 0 < k <= array1.size() * array2.size()
 * 输出描述:
 * 满足要求的最小和
 * 示例1
 * 输入
 * 3 1 1 2
 * 3 1 2 3
 * 2
 * 输出
 * 4
 * 说明
 * 用例中，需要取2对元素
 * 取第一个数组第0个元素与第二个数组第0个元素组成1对元素[1,1];
 * 取第一个数组第1个元素与第二个数组第0个元素组成1对元素[1,1];
 * 求和为1+1+1+1=4，为满足要求的最小和
 */
public class Code_整数对最小和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        int count = Integer.parseInt(sc.nextLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                list.add(Integer.parseInt(str1[i]) + Integer.parseInt(str2[j]));
            }
        }
        Collections.sort(list);
        int res = 0;
        for (int i = 0; i < count; i++) {
            res += list.get(i);
        }
        System.out.println(res);
    }
}
