package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124579505?spm=1001.2014.3001.5502
 * 给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 * 说明：
 * *数组中数字范围[0, 1000]
 * *最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
 * *输入非法返回-1
 * 输入描述:
 * 第一行输入M， M标识数组大小
 * 第二行输入M个数，标识数组内容
 * 第三行输入N，N表达需要计算的最大、最小N个数
 * 输出描述:
 * 输出最大N个数与最小N个数的和。
 * 示例1
 * 输入
 * 5
 * 95 88 83 64 100
 * 2
 * 输出
 * 342
 * 说明
 * 最大2个数[100,95],最小2个数[83,64], 输出为342
 * 示例2
 * 输入
 * 5
 * 3 2 3 4 2
 * 2
 * 输出
 * -1
 * 说明
 * 最大2个数[4,3],最小2个数[3,2], 有重叠输出为-1
 */
public class Code_最大N个数与最小N个数的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        int max = Integer.parseInt(sc.nextLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(Integer.parseInt(input[i]));
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        //找到最大N个数的最小值 ma < mi
        //最小N个数的最大值 mi
        List<Integer> listMin = list.subList(0,max);
        List<Integer> listMax = list.subList(list.size() - max,list.size());
        if (listMin.get(max-1) > listMax.get(0)){
            System.out.println(-1);
        }else {
            int total = 0;
            for (int i = 0; i < max; i++) {
                total += listMin.get(i) + listMax.get(i);
            }
            System.out.println(total);
        }
    }
}
