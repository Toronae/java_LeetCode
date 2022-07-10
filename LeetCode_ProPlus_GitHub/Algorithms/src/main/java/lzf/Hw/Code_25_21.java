package lzf.Hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数据分类
 * https://www.nowcoder.com/discuss/62516?order=0&page=1&pos=23&type=0
 */
public class Code_25_21 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        String[] strs = str.split("\\、");
//        int c = Integer.parseInt(strs[0]);
//        int b = Integer.parseInt(strs[1]);

        String[] strs = {"256","257","258","259","260","261","262","263","264","265"};
        int c = 3,b=4;
        int f1,f2,f3,f4;
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < strs.length; ++i) {
            int temp = Integer.parseInt(strs[i]);
            f1 = temp >> 24;
            f2 = (temp & 0x00FFFFFF)>>16;
            f3 = (temp  & 0x0000FFFF) >> 8;
            f4 = (temp & 0x000000FF);
            int sum = f1 + f2 + f3 + f4;
            int tt = sum % b;
            if(tt < c) {
                if(map.containsKey(tt)) {
                    int x = map.get(tt) + 1;
                    map.put(tt, x);
                    if(x > count) {
                        count = x;
                    }
                } else {
                    map.put(tt, 1);
                }

            }
        }
        System.out.println(count);

    }
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt(), b = in.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<10;++i) {
            int num = in.nextInt();
            int sum = 0;
            while(num>0) {
                sum += num & 0xff;
                num >>= 8;
            }
            int res = sum%b;
            if(res<c) {
                if(!map.containsKey(res)) {
                    map.put(res, 1);
                }else {
                    map.replace(res, map.get(res)+1);
                }
            }
        }
        int max = 0;
        for(int value : map.values()) {
            max = Math.max(max, value);
        }
        System.out.println(max);
    }*/
}
