package lzf.Hwod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124516351?spm=1001.2014.3001.5502
 * 一辆运送快递的货车，运送的快递均放在大小不等的长方体快递盒中，为了能够装载更多的快递，同时不能让货车超载，需要计算最多能装多少个快递。
 * 注：快递的体积不受限制，快递数最多1000个，货车载重最大50000。
 * 输入描述:
 * 第一行输入每个快递的重量，用英文逗号分隔，如：5,10,2,11
 * 第二行输入货车的载重量，如：20
 * 不需要考虑异常输入。
 * 输出描述:
 * 输出最多能装多少个快递，如：3
 * 示例1：
 * 输入
 * 5,10,2,11
 * 20
 * 输出
 * 3
 * 说明
 * 货车的载重量为20，最多只能放三个快递5、10、2，因此输出3
 */
public class Code_快递运输 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");//2 5 10 11 2510
        int max = Integer.parseInt(sc.nextLine());//20
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        System.out.println(calc(arr,0,0,0,max));
    }

    private static int calc(int[] arr,int idx,int count,int total,int max){
        if (total > max || idx>= arr.length){
            return count-1;
        }
        int cl1 = calc(arr, idx+1, count+1,total + arr[idx],max);
        int cl2 = calc(arr, idx+1, count, total,max);
        return Math.max(cl1,cl2);
    }
}
