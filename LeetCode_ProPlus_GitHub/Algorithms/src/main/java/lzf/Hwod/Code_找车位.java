package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124551079?spm=1001.2014.3001.5502
 * 停车场有一横排车位，0代表没有停车，1代表有车。至少停了一辆车在车位上，也至少有一个空位没有停车。
 * 为了防剐蹭，需为停车人找到一个车位，使得距停车人的车最近的车辆的距离是最大的，返回此时的最大距离。
 * 输入描述:
 * 1、一个用半角逗号分割的停车标识字符串，停车标识为0或1，0为空位，1为已停车。
 * 2、停车位最多100个。
 * 输出描述:
 * 输出一个整数记录最大距离。
 * 示例1
 * 输入
 * 1,0,0,0,0,1,0,0,1,0,1
 * 输出
 * 2
 * 说明
 * 当车停在第3个位置上时，离其最近的的车距离为2（1到3）。
 * 当车停在第4个位置上时，离其最近的的车距离为2（4到6）。
 * 其他位置距离为1。
 * 因此最大距离为2
 */
public class Code_找车位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                continue;
            }
            max = Math.max(max,calcDis(arr,i));
        }
        System.out.println(max);
    }
    //1,0,0,0,1,0,0,1
    private static int calcDis(int[] arr,int idx){
        int left = 0;
        int right = 0;
        for (int i = 0; i < idx; i++) {
            if (arr[i] == 1){
                left = i;
            }
        }
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1){
                right =i;
                break;
            }
        }
        return Math.min(idx - left,right - idx);
    }
}
