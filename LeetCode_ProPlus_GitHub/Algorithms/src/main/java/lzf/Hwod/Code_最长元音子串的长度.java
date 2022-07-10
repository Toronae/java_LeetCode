package lzf.Hwod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124579505?spm=1001.2014.3001.5502
 * 定义：当一个字符串只有元音字母（aeiouAEIOU）组成，称为元音字符串。
 * 现给定一个字符串，请找出其中最长的元音字符子串，并返回其长度；如果找不到，则返回0。
 * 子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 * 输入描述:
 * 一个字符串，其长度范围：0 < length <= 65535。
 * 字符串仅由字符a-z和A-Z组成。
 * 输出描述:
 * 一个整数，表示最长的元音字符子串的长度。
 * 示例1
 * 输入
 * asdbuiodevauufgh
 * 输出
 * 3
 * 说明
 * 样例1解释：最长元音子串为 “uio” 或 “auu”，其长度都为3，因此输出3
 */
public class Code_最长元音子串的长度 {
    public static void main(String[] args) {
        char[] arr = {'a','e','i','o','u'};
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int idx = 0;
        int max = 0;
        int tem = 0;

        while (idx < input.length()){
            char ch = input.charAt(idx);
            if (list.contains(ch)) {
                tem++;
            }else {
                if (tem != 0) {
                    max = Math.max(max,tem);
                    tem = 0;
                }
            }
            idx++;
        }
        System.out.println(max);
    }
}
