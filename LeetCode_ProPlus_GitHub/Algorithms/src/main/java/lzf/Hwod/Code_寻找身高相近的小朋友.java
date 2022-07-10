package lzf.Hwod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124551079?spm=1001.2014.3001.5502
 * 小明今年升学到小学一年级，来到新班级后发现其他小朋友们身高参差不齐，然后就想基于各小朋友和自己的身高差对他们进行排序，请帮他实现排序。
 * 输入描述:
 * 第一行为正整数H和N，0<H<200，为小明的身高，0<N<50，为新班级其他小朋友个数。
 * 第二行为N个正整数H1-HN，分别是其他小朋友的身高，取值范围0<Hi<200（1<=i<=N），且N个正整数各不相同。
 * 输出描述:
 * 输出排序结果，各正整数以空格分割。和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在最后，如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
 * 示例1
 * 输入
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105
 * 输出
 * 99 101 98 102 97 103 96 104 95 105
 * 说明
 * 小明身高100，班级学生10个，身高分别为95 96 97 98 99 101 102 103 104 105，按身高差排序后结果为：99 101 98 102 97 103 96 104 95 105。
 */
public class Code_寻找身高相近的小朋友 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int myHigh = Integer.parseInt(input[0]);
        int count = Integer.parseInt(input[1]);
        String[] students = sc.nextLine().split(" ");
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int highTemp = Integer.parseInt(students[i]);
            list.add(new Student(highTemp, Math.abs(myHigh - highTemp)));
        }
        list.sort(null);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).high + " ");
        }
        System.out.println();
    }
    private static class Student implements Comparable<Student>{
        private int high;
        private int gap;

        public Student(int high, int gap) {
            this.high = high;
            this.gap = gap;
        }

        @Override
        public int compareTo(Student stu) {
            if (stu.gap != this.gap){
                return this.gap - stu.gap ;
            }else {
                return this.high - stu.high ;
            }
        }
    }
}
