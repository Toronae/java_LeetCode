package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/cxh21627/article/details/125215772
 * 输入一串字符串，字符串长度不超过100，查找字符串中相同字符连续出现的最大次数。
 * 输入描述：
 * 输入只有一行，包含一个长度不超过100的字符串
 * 输出描述：
 * 输出只有一行，输出相同字符串连续出现的最大次数
 * 说明：
 * 字符串区分大小写
 * 示例：
 * 1.输入：
 * hello
 * 输出：2
 * 2.输入：
 * word
 * 输出：1
 * 3.输入：
 * aaabbc
 * 输出：
 * 3
 */
public class Code_连续字符最大次数 {
    public static void main(String[] args) {
        int maxNum = 1;
        int count = 1;
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count += 1;
                if (count >= maxNum) {
                    maxNum = count;
                }
            } else {
                count = 1;
            }
        }
        System.out.println(maxNum);
    }
}
