package lzf.Hwod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124509176?spm=1001.2014.3001.5502
 * 给定一个元素类型为小写字符串的数组，请计算两个没有相同字符的元素 长度乘积的最大值，如果没有符合条件的两个元素，返回0。
 * 输入描述:
 * 输入为一个半角逗号分隔的小写字符串的数组，2 <= 数组长度<=100，0 < 字符串长度<= 50。
 * 输出描述:
 * 两个没有相同字符的元素 长度乘积的最大值。
 * 示例1
 * 输入
 * iwdvpbn,hk,iuop,iikd,kadgpf
 * 输出
 * 14
 * 说明
 * 数组中有5个元素。
 * iwdvpbn与hk无相同的字符，满足条件，iwdvpbn的长度为7，hk的长度为2，乘积为14（7*2）。
 * iwdvpbn与iuop、iikd、kadgpf均有相同的字符，不满足条件。
 * iuop与iikd、kadgpf均有相同的字符，不满足条件。
 * iikd与kadgpf有相同的字符，不满足条件。
 * 因此，输出为14。
 */
public class Code_计算最大乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = i+1; j < split.length; j++) {
                if (!checkHaveSame(split[i], split[j])){
                    max = Math.max(max,split[i].length() * split[j].length());
                }
            }
        }
        System.out.println(max);
    }

    private static boolean checkHaveSame(String str1,String str2){
        //字符串排序
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int idx1 = 0;
        int idx2 = 0;
        while (idx1<str1.length() && idx2< str2.length()){
            if (chars1[idx1] == chars2[idx2]){
                return true;
            }else if (chars1[idx1] > chars2[idx2]){
                idx2++;
            }else if (chars1[idx1] < chars2[idx2]){
                idx1++;
            }
        }
        return false;
    }
}
