package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124551079?spm=1001.2014.3001.5502
 * 在学校中，N个小朋友站成一队， 第i个小朋友的身高为height[i]，
 * 第i个小朋友可以看到的第一个比自己身高更高的小朋友j，那么j是i的好朋友(要求j > i)。
 * 请重新生成一个列表，对应位置的输出是每个小朋友的好朋友位置，如果没有看到好朋友，请在该位置用0代替。
 * 小朋友人数范围是 [0, 40000]。
 * 输入描述:
 * 第一行输入N，N表示有N个小朋友
 * 第二行输入N个小朋友的身高height[i]，都是整数
 * 输出描述:
 * 输出N个小朋友的好朋友的位置
 * 示例1
 * 输入
 * 2
 * 100 95
 * 输出
 * 0 0
 * 说明
 * 第一个小朋友身高100，站在队尾位置，向队首看，没有比他身高高的小朋友，所以输出第一个值为0。
 * 第二个小朋友站在队首，前面也没有比他身高高的小朋友，所以输出第二个值为0。
 * 示例2
 * 输入
 * 8
 * 123 124 125 121 119 122 126 123
 * 输出
 * 1 2 6 5 5 6 0 0
 * 说明
 * 123的好朋友是1位置上的124
 * 124的好朋友是2位置上的125
 * 125的好朋友是6位置上的126
 * 以此类推
 */
public class Code_找朋友 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[count];
        for (int i = 0; i < input.length; i++) {
            //右边第一个比自己身高高的人
            int idx = 0;
            for (int j = i+1; j < input.length; j++) {
                if (Integer.parseInt(input[i]) < Integer.parseInt(input[j])){
                    idx = j;
                    break;
                }
            }
            arr[i] = idx;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i!= arr.length-1){
                System.out.print(arr[i] + " ");
            }else {
                System.out.print(arr[i]);
            }
        }
    }

}
