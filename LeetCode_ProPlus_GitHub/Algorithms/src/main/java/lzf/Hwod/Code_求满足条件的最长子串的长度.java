package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124643796?spm=1001.2014.3001.5502
 * 给定一个字符串，只包含字母和数字，按要求找出字符串中的最长（连续）子串的长度，字符串本身是其最长的子串，子串要求：
 * 1、 只包含1个字母(a~z, A~Z)，其余必须是数字；
 * 2、 字母可以在子串中的任意位置；
 * 如果找不到满足要求的子串，如全是字母或全是数字，则返回-1。
 * 输入描述：字符串(只包含字母和数字)
 * 输出描述：子串的长度
 * 示例1
 * 输入
 * abC124ACb
 * 输出
 * 4
 * 说明
 * 满足条件的最长子串是C124或者124A，长度都是4
 * 示例2
 * 输入
 * a5
 * 输出
 * 2
 * 说明
 * 字符串自身就是满足条件的子串，长度为2
 * 示例3
 * 输入
 * aBB9
 * 输出
 * 2
 * 说明
 * 满足条件的子串为B9，长度为2
 * 示例4
 * 输入
 * abcdef
 * 输出
 * -1
 * 说明
 * 没有满足要求的子串，返回-1
 */
public class Code_求满足条件的最长子串的长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        //双指针滑动
        int left = 0;
        int right = 1;
        int maxLe = -1;
        while (left < input.length() && right < input.length()){
            right++;
            String str = input.substring(left,right);//左取右不取
            if (checkStr(str)){
                maxLe = Math.max(str.length(),maxLe);
            }else {
                left++;
            }
        }
        System.out.println(maxLe);
    }

    private static boolean checkStr(String str){
        char[] chars = str.toCharArray();
        int wordCount = 0;
        int numCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')){
                if (++wordCount >= 2){
                    return false;
                }
            }else {
                numCount++;
            }
        }
        return numCount > 0 && wordCount > 0;
    }
}
