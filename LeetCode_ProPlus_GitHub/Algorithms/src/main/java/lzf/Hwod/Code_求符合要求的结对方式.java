package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124516351?spm=1001.2014.3001.5502
 * 用一个数组A代表程序员的工作能力，公司想通过结对编程的方式提高员工的能力，假设结对后的能力为两个员工的能力之和，求一共有多少种结对方式使结对后能力为N。
 * 输入描述:
 * 5
 * 1 2 2 2 3
 * 4
 * 第一行为员工的总人数，取值范围[1,1000]
 * 第二行为数组A的元素，每个元素的取值范围[1,1000]
 * 第三行为N的值，取值范围[1,1000]
 * 输出描述:
 * 4
 * 满足结对后能力为N的结对方式总数
 * 示例1
 * 输入
 * 5
 * 1 2 2 2 3
 * 4
 * 输出
 * 4
 * 说明
 * 满足要求的结对方式为：A[0]和A[4]，A[1]和A[2]，A[1]和A[3]，A[2]和A[3]
 */
public class Code_求符合要求的结对方式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        int target = Integer.parseInt(sc.nextLine());
        int[] arr = new int[people];
        for (int i = 0; i < people; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int count = 0;
        for (int i = 0; i < people; i++) {
            for (int j = i + 1; j < people; j++) {
                if (target == arr[i] + arr[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
