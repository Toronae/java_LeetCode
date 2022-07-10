package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124558394?spm=1001.2014.3001.5502
 * 给定一个非空数组（列表），其元素数据类型为整型，请按照数组元素十进制最低位从小到大进行排序，十进制最低位相同的元素，相对位置保持不变。
 * 当数组元素为负值时，十进制最低位等同于去除符号位后对应十进制值最低位。
 * 输入描述:
 * 给定一个非空数组，其元素数据类型为32位有符号整数，数组长度[1, 1000]
 * 输出描述:
 * 输出排序后的数组
 * 示例1
 * 输入
 * 1,2,5,-21,22,11,55,-101,42,8,7,32
 * 输出
 * 1,-21,11,-101,2,22,42,32,5,55,7,8
 */
public class Code_整型数组按个位值排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splits = sc.nextLine().split(",");
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < splits.length; i++) {
            int abs = Math.abs(Integer.parseInt(splits[i]));
            int res = abs % 10;
            List<Integer> list = map.getOrDefault(res, new ArrayList<>());
            list.add(Integer.parseInt(splits[i]));
            map.put(res,list);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            List<Integer> list = map.get(i);
            if (list!= null){
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j)).append(",");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
