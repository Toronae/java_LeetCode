package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124528902?spm=1001.2014.3001.5502
 * 给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序。
 * 输入描述:
 * 一个数组
 * 输出描述:
 * 去重排序后的数组
 * 示例1
 * 输入
 * 1,3,3,3,2,4,4,4,5
 * 输出
 * 3,4,1,2,5
 * 备注:
 * 数组大小不超过100
 * 数组元素值大小不超过100
 */
public class Code_数组去重和排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        Map<Integer,Integer> map = new HashMap<>();
        List<Order> list = new ArrayList<>();
        int idxInList = 0;
        for (int i = 0; i < split.length; i++) {
            int value = Integer.parseInt(split[i]);
            Order order = new Order(i,value,1);
            if (list.contains(order)){
                int idx = map.get(value);
                list.get(idx).count++;
            }else {
                map.put(value,idxInList++);
                list.add(order);
            }
        }
        list.sort(null);//能把下标重排吗？
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).value + ",");
        }

    }
    private static class Order implements Comparable<Order>{
        private int idx;//出场顺序
        private int value;
        private int count;

        public Order(int idx ,int value, int count) {
            this.idx = idx;
            this.value = value;
            this.count = count;
        }

        @Override
        public boolean equals(Object obj) {
            Order order = (Order) obj;
            return order.value == this.value;
        }

        @Override
        public int compareTo(Order order) {
            if (order.count != this.count){
                return order.count - this.count;
            }else {
                return this.idx - order.idx ;
            }
        }
    }
}
