package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124558394?spm=1001.2014.3001.5502
 * 给你一串未加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，
 * 数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]，
 * 例如：原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。
 * 输入描述:
 * 第一行为一个整数n（1<=n<=1000），表示有n组测试数据，每组数据包含一行，原文str（只含有小写字母，0<长度<=50）。
 * 输出描述:
 * 每组测试数据输出一行，表示字符串的密文
 * 示例1
 * 输入
 * 1
 * xy
 * 输出
 * ya
 * 说明
 * 第一个字符x偏移量是1，即为y，第二个字符y偏移量是2，即为a
 * 示例2
 * 输入
 * 2
 * xy
 * abcde
 * 输出
 * ya
 * bdgkr
 * 说明
 * 第二行输出字符偏移量分别为1、2、4、7、13
 */
public class Code_字符串加密 {
    private static int[] arrOff = new int[50];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        char[] arr = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z'};
        arrOff[0] = 1;
        arrOff[1] = 2;
        arrOff[2] = 4;
        for (int i = 3; i < 50; i++) {
            arrOff[i] = arrOff[i-1] + arrOff[i-2] + arrOff[i-3];
        }
        for (int i = 0; i < count; i++) {
            System.out.println(handleStr(sc.nextLine(),arr));
        }
    }

    public static String handleStr(String str,char[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int offset = arrOff[i];
            ch = arr[(ch -'a' +  offset) % 26];
            sb.append(ch);
        }
        return sb.toString();
    }
}
