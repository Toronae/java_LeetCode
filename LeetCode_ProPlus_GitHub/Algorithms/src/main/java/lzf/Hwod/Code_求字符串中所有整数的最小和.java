package lzf.Hwod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124528902?spm=1001.2014.3001.5502
 * 输入字符串s，输出s中包含所有整数的最小和
 * 说明
 * 字符串s，只包含 a-z A-Z ± ；
 * 合法的整数包括
 * 1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
 * 2）负整数 负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 输入描述:
 * 包含数字的字符串
 * 输出描述:
 * 所有整数的最小和
 * 示例1
 * 输入
 * bb1234aa
 * 输出
 * 10
 * 示例2
 * 输入
 * bb12-34aa
 * 输出
 * -31
 * 说明
 * 1+2+（-34） = 31
 */
public class Code_求字符串中所有整数的最小和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //原则1、正数所有都拆分
        //2、负数保留最大
        boolean fuShu = false;
        String tempNum = "-";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char tem = input.charAt(i);
            if (tem == '-'){
                fuShu = true;
                continue;
            }
            if (tem >= '0' && tem <= '9'){
                if (fuShu){ //只要不是字符就一直往下记录
                    tempNum += tem;
                }else {
                    list.add(Integer.parseInt(String.valueOf(tem)));
                }
            }else {
                if (tempNum != "-"){
                    list.add(Integer.parseInt(tempNum));
                    tempNum = "-";
                }
                fuShu = false;
            }
        }
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }
        System.out.println(total);
    }
}
