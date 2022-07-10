package lzf.Hwod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124558394?spm=1001.2014.3001.5502
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
 * 变换规则：交换字符串中任意两个不同位置的字符。
 * 输入描述:
 * 一串小写字母组成的字符串s
 * 输出描述:
 * 按照要求进行变换得到的最小字符串
 * 示例1
 * 输入
 * abcdef
 * 输出
 * abcdef
 * 说明
 * abcdef已经是最小字符串，不需要交换
 * 示例2
 * 输入
 * bcdefa
 * bacdefa
 * 输出
 * acdefb
 * aacdefb[abcdefa排序更大]
 * 说明
 * a和b进行位置交换，可以等到最小字符串
 * 备注:
 * s是都是小写字符组成
 * 1<=s.length<=1000
 */
public class Code_字符串变换最小字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);//最优解
        String str = input;
        for (int i = 0; i < input.length(); i++) {
            if (chars[i] == input.charAt(i)) {
                continue;
            }else {
                char aChar = chars[i];
                int i1 = input.lastIndexOf(String.valueOf(aChar));
                //i1 和i对调顺序即可
                str = input.substring(0,i) + aChar + input.substring(i+1,i1) + input.charAt(i) + input.substring(i1+1);
                break;
            }
        }
        System.out.println(str);
    }
}
