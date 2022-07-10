package lzf.Hwod;

import java.util.Scanner;

/**
 * 最长方连续方波信号
 * https://blog.csdn.net/csfun1/article/details/124643796?spm=1001.2014.3001.5502
 * 输入一串方波信号，求取最长的完全连续交替方波信号，并将其输出，如果有相同长度的交替方波信号，输出任一即可，方波信号高位用1标识，低位用0标识，如图：
 *
 * 说明：
 * 1） 一个完整的信号一定以0开始然后以0结尾，即010是一个完整信号，但101，1010，0101不是
 * 2）输入的一串方波信号是由一个或多个完整信号组成
 * 3） 两个相邻信号之间可能有0个或多个低位，如0110010，011000010
 * 4） 同一个信号中可以有连续的高位，如01110101011110001010，前14位是一个具有连续高位的信号
 * 5） 完全连续交替方波是指10交替，如01010是完全连续交替方波，0110不是
 * 输入描述:
 * 输入信号字符串（长度>=3且<=1024）：
 * 0010101010110000101000010
 * 注：输入总是合法的，不用考虑异常情况
 * 输出描述:
 * 输出最长的完全连续交替方波信号串：
 * 01010
 * 若不存在完全连续交替方波信号串，输出 -1
 * 示例1
 * 输入
 * 00101010101100001010010
 * 输出
 * 01010
 * 备注:
 * 输入信号串中有三个信号：0 010101010110(第一个信号段) 00 01010(第二个信号段) 010(第三个信号段)
 * 第一个信号虽然有交替的方波信号段，但出现了11部分的连续高位，不算完全连续交替方波，在剩下的连续方波信号串中01010最长
 */
public class Code_电信号 {
    private static int maxLength = Integer.MIN_VALUE;
    private static String res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.contains("00")) {//包含2各及以上的信号波
            String[] split = input.split("00");
            //0和尾要在后面和前面各添加一个0
            //其他的前后均要补0
            for (int i = 0; i < split.length; i++) {
                String temp = split[i];
                if (i == 0){
                    check(temp + "0");
                }else if (i == split.length -1){
                    check("0"+temp);
                }else {
                    check("0" + temp + "0");
                }
            }
        }else {//单信号波 01010
            check(input);
        }
        if (maxLength == Integer.MIN_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(res);
        }
    }
    private static void check(String str){//首位一定是以0开头的 00 /01
        char[] chars = str.toCharArray();
        boolean start = false;
        int startIdx = 0;
        int endIdx = -1;
        char pre = '1';
        for (int i = 0; i < chars.length; i++) {
            if (!start && i+1 < chars.length && chars[i] == '0' && chars[i+1] == '1'){
                start = true;
                startIdx = i;
                pre = '0';
                continue;
            }
            if (pre != chars[i]){
                pre = chars[i];
            }else if (pre =='1' && chars[i] == '1'){
                return;
            } else {
                endIdx = i;
                break;
            }
        }
        if (endIdx == -1){
            if (str.length() - startIdx > maxLength){
                maxLength = str.length() - startIdx;
                res = str.substring(startIdx);
            }
        }else {
            if (endIdx - startIdx > maxLength){
                maxLength = endIdx - startIdx;
                res = str.substring(startIdx,endIdx);
            }
        }
    }
}
