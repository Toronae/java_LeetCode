package lzf.Hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://blog.csdn.net/weixin_44219664/article/details/123809385
 * 喊7的次数重排
 */
public class Code_2_21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = input.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += input[i];
        }
        System.out.println(count);
        int[] res = new int[3];
        int flag = 0;
        for (int i = 1; i <=200 ; i++) {
            if (count == flag) {
                break;
            }
            int index = 0;
            if (i%7==0 || Integer.toString(i).indexOf('7')!=-1){
                if (i%len==0) {
                    index = len-1;
                }else {
                    index = i%len-1;
                }
                res[index]++;
                flag++;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
