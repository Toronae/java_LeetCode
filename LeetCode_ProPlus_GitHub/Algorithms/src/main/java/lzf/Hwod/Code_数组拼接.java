package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124528902?spm=1001.2014.3001.5502
 * 现在有多组整数数组，需要将它们合并成一个新的数组。合并规则，从每个数组里按顺序取出固定长度的内容合并到新的数组中，取完的内容会删除掉，如果该行不足固定长度或者已经为空，则直接取出剩余部分的内容放到新的数组中，继续下一行。
 * 输入描述:
 * 第一行是每次读取的固定长度，0<长度<10
 * 第二行是整数数组的数目，0<数目<1000
 * 第3-n行是需要合并的数组，不同的数组用回车换行分隔，数组内部用逗号分隔，最大不超过100个元素。
 * 输出描述:
 * 输出一个新的数组，用逗号分隔。
 * 示例1
 * 输入
 * 3
 * 2
 * 2,5,6,7,9,5,7
 * 1,7,4,3,4
 * 输出
 * 2,5,6,1,7,4,7,9,5,3,4,7
 * 说明
 * 1、获得长度3和数组数目2。
 * 2、先遍历第一行，获得2,5,6；
 * 3、再遍历第二行，获得1,7,4；
 * 4、再循环回到第一行，获得7,9,5；
 * 5、再遍历第二行，获得3,4；
 * 6、再回到第一行，获得7，按顺序拼接成最终结果。
 * 示例2
 * 输入
 * 4
 * 3
 * 1,2,3,4,5,6
 * 1,2,3
 * 1,2,3,4
 * 输出
 * 1,2,3,4,1,2,3,1,2,3,4,5,6
 */
public class Code_数组拼接 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = Integer.parseInt(sc.nextLine());
        int num = Integer.parseInt(sc.nextLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        //存
        for (int i = 0; i < num; i++) {
            String[] split = sc.nextLine().split(",");
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                list.add(Integer.parseInt(split[j]));
            }
            map.put(i,list);
        }
        //取
        List<Integer> list = new ArrayList<>();
        while (!map.isEmpty()){
            Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
            List<Integer> removeKey = new ArrayList<>();
            while (iterator.hasNext()){
                Map.Entry<Integer, List<Integer>> next = iterator.next();
                List<Integer> value = next.getValue();
                int start = 0;
                for (int i = 0; i < value.size(); i++) {
                    if (i<limit){
                        list.add(value.get(i));
                        start++;
                    }
                }
                value = value.subList(start,value.size());

                if (value.size() == 0){
                    removeKey.add(next.getKey());
                }else {
                    next.setValue(value);
                }
            }
            for (int i = 0; i < removeKey.size(); i++) {
                map.remove(removeKey.get(i));
            }
        }
        System.out.println(list);
    }
}
