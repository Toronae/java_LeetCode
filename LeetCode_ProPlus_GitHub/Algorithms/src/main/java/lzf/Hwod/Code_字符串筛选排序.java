package lzf.Hwod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124558394?spm=1001.2014.3001.5502
 * 输入一个由n个大小写字母组成的字符串，按照Ascii码值从小到大的排序规则，查找字符串中第k个最小ascii码值的字母（k>=1），输出该字母所在字符串的位置索引(字符串的第一个字符位置索引为0）。
 * k如果大于字符串长度，则输出最大ascii值的字母所在字符串的位置索引，如果有重复的字母，则输出字母的最小位置索引。
 * 输入描述:
 * 第一行输入一个由大小写字母组成的字符串
 * 第二行输入k，k必须大于0，k可以大于输入字符串的长度
 * 输出描述:
 * 输出字符串中第k个最小ascii码值的字母所在字符串的位置索引。k如果大于字符串长度，则输出最大ascii值的字母所在字符串的位置索引，如果第k个最小ascii码值的字母存在重复，则输出该字母的最小位置索引。
 * 示例1
 * 输入
 * AbCdeFG
 * 3
 * 输出
 * 5
 * 说明
 * 根据ascii码值排序，第3个最小ascii码值的字母为F，F在字符串中的位置索引为5（0为字符串的第一个字母位置索引）
 * 示例2
 * 输入
 * fAdDAkBbBq
 * 4
 * 输出
 * 6
 * 说明
 * 根据ascii码值排序，前4个字母为AABB ，由于B重复，则只取B的（第一个）最小位置索引6 ，而不是第二个B的位置索引8
 */
public class Code_字符串筛选排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int turn = Integer.parseInt(sc.nextLine());
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        char ch = ' ';
        if (turn > chars.length){
            ch = chars[chars.length-1];
            System.out.println(input.lastIndexOf(String.valueOf(ch)));
        }else {
            ch = chars[turn-1];
            System.out.println(input.indexOf(ch));
        }
    }
}
