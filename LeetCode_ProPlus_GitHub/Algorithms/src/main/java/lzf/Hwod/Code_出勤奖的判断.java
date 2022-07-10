package lzf.Hwod;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://blog.csdn.net/AOBO516/article/details/125228558
 * https://blog.csdn.net/qq_35684085/article/details/124601511
 * 公司用一个字符串来标识员工的出勤信息
 * absent:    缺勤
 * late:      迟到
 * leaveearly:早退
 * present:   正常上班
 *
 * 现需根据员工出勤信息,判断本次是否能获得出勤奖,
 * 能获得出勤奖的条件如下：
 * 1.缺勤不超过1次
 * 2.没有连续的迟到/早退
 * 3.任意连续7次考勤 缺勤/迟到/早退 不超过3次。
 *
 * 输入描述
 * 用户的考勤数据字符串记录条数  >=1
 * 输入字符串长度 <10000 ;
 * 不存在非法输入
 * 如：
 * 2
 * present
 * present absent present present leaveearly present absent
 * 输出描述
 * 根据考勤数据字符串
 * 如果能得到考勤奖输出true否则输出false
 * 对于输出示例的结果应为
 * true false
 * 示例1
 * 输入
 * 2
 * present
 * present present
 * 输出
 * true true
 * 示例2
 * 输入
 * 2
 * present
 * present absent present present leaveearly present absent
 * 输出
 * true false
 * 思路分析
 * 感觉题目有点怪，一行是一个月的考勤吗？
 * 不管是否符合实际，就是根据得出勤奖的条件判断，并打印结果。
 */
public class Code_出勤奖的判断 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();


        String[] records = new String[n];
        for (int i = 0; i < n; i++) {
            records[i] = scanner.nextLine();
        }

        ArrayList<String> res = new ArrayList<>(n);
        for (String record : records) {
            res.add(String.valueOf(extracted(record.split(" "))));
        }

        System.out.println(String.join(" ", res));
    }

    private static boolean extracted(String[] s) {
        // 1.缺勤不超过1次
        for (int j = 0; j < s.length; j++) {
            if ("absent".equals(s[j])) {
                return false;
            }
        }

        // 2.没有连续的迟到/早退
        if (s.length >= 2) {
            for (int i = 1; i < s.length; i++) {
                String yesterday = s[i - 1];
                String today = s[i];
                if (("late".equals(yesterday) || "leaveearly".equals(yesterday))
                        && ("late".equals(today) || "leaveearly".equals(today))) {
                    return false;
                }
            }
        }

        // 3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
        if (s.length >= 7) {
            for (int i = 0; i < s.length; i++) {
                int count = 0;
                if (i + 7 > s.length) {
                    break;
                }
                for (int j = i; j < i + 7; j++) {
                    String today = s[j];
                    if ("absent".equals(today) || "late".equals(today) || "leaveearly".equals(today)) {
                        count++;
                        if (count >= 3) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
