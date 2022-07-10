package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124516351?spm=1001.2014.3001.5502
 * 一个工厂有m条流水线，来并行完成n个独立的作业，该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 * 现给定流水线个数m，需要完成的作业数n, 每个作业的处理时间分别为t1,t2…tn。请你编程计算处理完所有作业的耗时为多少？
 * 当n>m时，首先处理时间短的m个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 * 输入描述:
 * 第一行为2个整数（采用空格分隔），分别表示流水线个数m和作业数n；
 * 第二行输入n个整数（采用空格分隔），表示每个作业的处理时长t1,t2…tn。
 * 0< m,n<100，0<t1,t2…tn<100。
 * 注：保证输入都是合法的。
 * 输出描述:
 * 输出处理完所有作业的总时长
 * 示例1
 * 输入
 * 3 5
 * 8 4 3 2 10
 * 输出
 * 13
 * 说明
 * 1、先安排时间为2、3、4的3个作业。
 * 2、第一条流水线先完成作业，然后调度剩余时间最短的作业8。
 * 3、第二条流水线完成作业，然后调度剩余时间最短的作业10。
 * 4、总工耗时就是第二条流水线完成作业的时间13（3+10）
 */
public class Code_流水线 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String[] job = sc.nextLine().split(" ");
        int med = Integer.parseInt(input[0]);
        int[] arr = new int[job.length];
        for (int i = 0; i < job.length; i++) {
            arr[i] = Integer.parseInt(job[i]);
        }
        Arrays.sort(arr);
        List<Medic> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.size() <med){
                list.add(new Medic(arr[i],arr[i]));
            }else {
                //找到数组中 total最小的medic 加进去
                Collections.sort(list);
                Medic medic = list.get(0);
                medic.total += arr[i];
            }
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1).total);
    }
    static class Medic implements Comparable{
        private int end;
        private int total;

        public Medic(int end, int total) {
            this.end = end;
            this.total = total;
        }

        @Override
        public int compareTo(Object obj) {
            Medic medic= (Medic)obj;
            return this.total - medic.total;
        }
    }
}
