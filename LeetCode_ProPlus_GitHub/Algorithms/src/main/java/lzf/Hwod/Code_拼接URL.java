package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124516351?spm=1001.2014.3001.5502
 * 给定一个URL前缀和URL后缀，通过","分割，需要将其连接为一个完整的URL，如果前缀结尾和后缀开头都没有“/”，需自动补上“/”连接符，如果前缀结尾和后缀开头都为“/”，需自动去重。
 * 约束：不用考虑前后缀URL不合法情况。
 * 输入描述:
 * URL前缀（一个长度小于100的字符串),URL后缀（一个长度小于100的字符串）。
 * 输出描述:
 * 拼接后的URL。
 * 示例1
 * 输入
 * /acm,/bb
 * 输出
 * /acm/bb
 * 示例2
 * 输入
 * /abc/,/bcd
 * 输出
 * /abc/bcd
 * 示例3
 * 输入
 * /acd,bef
 * 输出
 * /acd/bef
 * 示例4
 * 输入
 * ,
 * 输出
 * /
 */
public class Code_拼接URL {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] URL = in.nextLine().split(",");
        StringBuilder sb = new StringBuilder();
        if (URL.length == 0) {
            System.out.println("/");
            return;
        }
        sb.append("/");
        sb.append(URL[0]);
        sb.append("/");
        sb.append(URL[1]);
        System.out.println((sb.toString()).replaceAll("/+", "/"));
    }
}
