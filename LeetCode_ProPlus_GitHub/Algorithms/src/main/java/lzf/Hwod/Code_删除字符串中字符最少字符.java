package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124528902?spm=1001.2014.3001.5502
 * 删除字符串中出现次数最少的字符，如果有多个字符出现次数一样，则都删除。
 * 输入描述:
 * 输入abcdd
 * 字符串中只包含小写英文字母。
 * 输出描述:
 * dd
 * 示例1
 * 输入
 * abcdd
 * 输出
 * dd
 * 示例2
 * 输入
 * aabbccdd
 * 输出
 * empty
 * 说明
 * 如果字符串的字符都被删除，则范围empty
 */
public class Code_删除字符串中字符最少字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            int orDefault = map.getOrDefault(String.valueOf(input.charAt(i)), 0);
            map.put(String.valueOf(input.charAt(i)),orDefault+1);
        }
        int less = Collections.min(map.values());
        StringBuilder res = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (Map.Entry<String,Integer> mp:map.entrySet()) {
            int times = mp.getValue();
            if (times == less) {
                set.add(mp.getKey());
            }
        }
        for (int i = 0; i < input.length(); i++) {
            if (!set.contains(String.valueOf(input.charAt(i)))) {
                res.append(input.charAt(i));
            }
        }
        if (res.length() == 0){
            System.out.println("empty");
        }else {
            System.out.println(res);
        }
    }
}
