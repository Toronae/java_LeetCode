package lzf.Hwod;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://blog.csdn.net/piratedota/article/details/124947671
 * 标题：敏感字段加密 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 【敏感字段加密】给定一个由多个命令字组成的命令字符串：
 * 1、字符串长度小于等于127字节，只包含大小写字母，数字，下划线和偶数个双引号；
 * 2、命令字之间以一个或多个下划线_进行分割；
 * 3、可以通过两个双引号""来标识包含下划线_的命令字或空命令字（仅包含两个双引号的命令字），双引号不会在命令字内部出现；
 * 请对指定索引的敏感字段进行加密，替换为******（6个*），并删除命令字前后多余的下划线_。如果无法找到指定索引的命令字，输出字符串ERROR。
 * 输入描述:
 * 输入为两行，第一行为命令字索引K（从0开始），第二行为命令字符串S。
 * 输出描述:
 * 输出处理后的命令字符串，如果无法找到指定索引的命令字，输出字符串ERROR
 * 示例1
 * 输入
 * 1
 * password__a12345678_timeout_100
 * 输出
 * password_******_timeout_100
 * 示例2
 * 输入
 * 2
 * aaa_password_“a12_45678"timeout__100"”_
 * 输出
 * aaa_password_******timeout_100""
 * */

public class Code_敏感字段加密 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();

        char[] chars = line.toCharArray();

        ArrayList<String> sl = new ArrayList<>();
        StringBuilder buf = new StringBuilder();
        boolean b = false;
        for (char c : chars) {
            if (c == '"') {
                b = !b;
            }
            if (!b && c == '_') { // 分割保存
                if (buf.length() > 0) {
                    sl.add(buf.toString());
                }
                buf.setLength(0);
            } else {
                buf.append(c);
            }
        }
        if (buf.length() > 0) {
            sl.add(buf.toString());
        }
        if (sl.size() < k) {
            System.out.println("ERROR");
            return;
        }
        StringBuilder bu = new StringBuilder();
        for (int i = 0; i < sl.size(); i++) {
            if (i + 1 == k) {
                bu.append("******").append("_");
            } else {
                bu.append(sl.get(i)).append("_");
            }
        }
        bu.deleteCharAt(bu.length() - 1);
        System.out.println(bu);
    }
}
