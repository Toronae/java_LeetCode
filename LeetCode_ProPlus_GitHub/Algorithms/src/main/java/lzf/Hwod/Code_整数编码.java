package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124558394?spm=1001.2014.3001.5502
 * 实现一种整数编码方法，使得待编码的数字越小，编码后所占用的字节数越小。
 * 编码规则如下：
 * 1、编码时7位一组，每个字节的低7位用于存储待编码数字的补码。
 * 2、字节的最高位表示后续是否还有字节，置1表示后面还有更多的字节，置0表示当前字节为最后一个字节。
 * 3、采用小端序编码，低位和低字节放在低地址上。
 * 3、编码结果按16进制数的字符格式输出，小写字母需转换为大写字母。
 * 输入描述:
 * 输入的为一个字符串表示的非负整数
 * 输出描述:
 * 输出一个字符串，表示整数编码的16进制码流
 * 示例1
 * 输入
 * 0
 * 输出
 * 00
 * 说明
 * 输出的16进制字符，不足两位的前面补0，如00、01、02。
 * 示例2
 * 输入
 * 100
 * 输出
 * 64
 * 说明
 * 100的二进制表示为0110 0100，只需要一个字节进行编码；
 * 字节的最高位置0，剩余7位存储数字100的低7位（110 0100），所以编码后的输出为64。
 * 示例3
 * 输入
 * 1000
 * 输出
 * E807
 * 说明
 * 1000的二进制表示为0011 1110 1000，至少需要两个字节进行编码；
 * 第一个字节最高位置1，剩余的7位存储数字1000的第一个低7位（110 1000），所以第一个字节的二进制为1110 1000，即E8；
 * 第二个字节最高位置0，剩余的7位存储数字1000的第二个低7位（000 0111），所以第一个字节的二进制为0000 0111，即07；
 * 采用小端序编码，所以低字节E8输出在前，高字节07输出在后。
 * 备注:
 * 待编码的数字取值范围为[0, 1<<64 - 1]
 */
public class Code_整数编码 {
    public static void main(String[] args) {
        char[] arr = {'A','B','C','D','E','F','G','H','I','J','K','L',
                'M','N','O','P','K','R','S','T','U','V','W','X','Y','Z'};
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();//1000
        String str = Integer.toBinaryString(input);//11 1110 1000
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while (str.length() > 0){//先找到低7位
            if (str.length() > 7){
                flag = true;
            }else {//2进制不足7位时补0
                flag = false;
                int mid = 7 - str.length();
                for (int i = 0; i < mid; i++) {
                    str = "0" + str;
                }
            }
            String sub = str.substring(str.length() - 7);
            str = str.substring(0,str.length() - 7);
            if (flag){
                sub = "1" + sub;
            }else {
                sub = "0" + sub;
            }
            String res = Integer.toHexString(Integer.parseInt(sub, 2));
            if (res.length()<2){//16进制不足2位补0
                res = "0" + res;
            }
            for (int i = 0; i < res.length(); i++) {
                char ch = res.charAt(i);
                if (ch>= 'a' && ch<= 'z'){
                    ch = arr[ch - 'a'];
                }
                sb.append(ch);
            }
        }
        //每个字符如果是小写要转成大写
        System.out.println(sb);
    }

}
