package lzf.Hwod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124528902?spm=1001.2014.3001.5502
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为N，每个团队可以由1人或2人组成，且1个人只能参加1个团队，请计算出最多可以派出多少支符合要求的团队？
 * 输入描述:
 * 5
 * 3 1 5 7 9
 * 8
 * 第一行数组代表总人数，范围[1,500000]
 * 第二行数组代表每个人的能力，每个元素的取值范围[1, 500000]，数组的大小范围[1,500000]
 * 第三行数值为团队要求的最低能力值，范围[1, 500000]
 * 输出描述:
 * 3
 * 最多可以派出的团队数量
 * 示例1
 * 输入
 * 5
 * 3 1 5 7 9
 * 8
 * 输出
 * 3
 * 说明
 * 3,5组成一队，1,7组成一队，9自己一个队，故输出3
 */
public class Code_求最多可以派出多少支团队 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        int limit = Integer.parseInt(sc.nextLine());
        int maxTeam = 0;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            int tem = Integer.parseInt(input[i]);
            if (tem >= limit){
                maxTeam++;
            }else {
                arr[i] = tem;
            }
        }
        Arrays.sort(arr);//1 2 3 5 6
        int left = 0;
        int right = arr.length-1;
        while (left< right){
            if (arr[left] + arr[right] < limit){//最小+最大 < min
                left++;
                continue;
            }else {//min + max >= limit
                maxTeam++;
                left++;
                right--;
            }
        }
        System.out.println(maxTeam);
    }
}
