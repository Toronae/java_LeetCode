package lzf.Hwod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124509176?spm=1001.2014.3001.5502
 * 给定一个正整数数组，检查数组中是否存在满足规则的数字组合
 * 规则：
 * A = B + 2C
 * 输入描述:
 * 第一行输入数组的元素个数。
 * 接下来一行输入所有数组元素，用空格隔开。
 * 输出描述:
 * 如果存在满足要求的数，在同一行里依次输出规则里A/B/C的取值，用空格隔开。
 * 如果不存在，输出0。
 * 示例1：
 * 输入
 * 4
 * 2 7 3 0
 * 输出
 * 7 3 2
 * 说明
 * 7 = 3 + 2 * 2
 * 示例2：
 * 输入
 * 3
 * 1 1 1
 * 输出
 * 0
 * 说明
 * 找不到满足条件的组合
 * 备注:
 * 数组长度在3-100之间。
 * 数组成员为0-65535，数组成员可以重复，但每个成员只能在结果算式中使用一次。如：数组成员为[0, 0, 1, 5]，0出现2次是允许的，但结果0 = 0 + 2 * 0是不允许的，因为算式中使用了3个0。
 * 用例保证每组数字里最多只有一组符合要求的解。
 */
public class Code_检查是否存在满足条件的数字组合 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        int[] arr = new int[count];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (checkAdd(arr,i,j)) {
                    return;
                }
            }
        }
        System.out.println(0);
    }

    private static boolean checkAdd(int[] arr,int idx1,int idx2){//a
        int sub1 = 2 * arr[idx1] + arr[idx2];
        int sub2 = arr[idx1] + 2 * arr[idx2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sub1 && i> idx1 && i> idx2) {
                System.out.println(sub1 + " " + arr[idx2] + " " + arr[idx1]);
                return true;
            }
            if (i> idx1 && i> idx2 && arr[i] == sub2) {
                System.out.println(sub1 + " " + arr[idx1] + " " + arr[idx2]);
                return true;
            }
        }
        return false;
    }
}
