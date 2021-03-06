package lzf.Hwod;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * (200)
 * https://blog.csdn.net/weixin_45111739/article/details/122593219
 * 警察在侦破一个案件时，得到了线人给出的可能犯罪时间，形如 “HH:MM” 表示的时刻。
 * 根据警察和线人的约定，为了隐蔽，该时间是修改过的，解密规则为：利用当前出现过的数字，构造下一个距离当前时间最近的时刻，则该时间为可能的犯罪时间。每个出现数字都可以被无限次使用。"
 */
public class Code_解密犯罪时间 {
    public static String fun(String time) {
        char[] chars = time.toCharArray();
        //单个数字list
        ArrayList<Integer> nums = new ArrayList<>();
        for (char c : chars) {
            if (c != ':') {
                nums.add(c - '0');
            }
        }
        String[] split = time.split(":");
        //小时
        Integer H = Integer.parseInt(split[0]);
        //分钟
        Integer M = Integer.parseInt(split[1]);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            for (int j : nums) {
                if (i <= 5) {
                    list.add(i * 10 + j);
                }
            }
        }
        //备选项排序，既可当H，也可以当M
        list.sort(Comparator.comparing(o -> o));
        //仅仅改变分钟就能得到最近的值
        for (int i : list) {
            if (i <= M) {
                continue;
            }
            //12:13 -> 12:31
            return format(H + ":" + i);
        }
        //小时数在23以下，可以使用最近的小时数
        if (H != 23) {
            for (int i : list) {
                if (i <= H) {
                    continue;
                }
                //确保i的合法性
                if (i<=23){
                    //12:59 ->15:11
                    return format(i + ":" + list.get(0));
                }
            }
        }
        //无法改别最近的小时与分钟。如23:59,00:00,15:15
        return format(list.get(0) + ":" + list.get(0));
    }

    public static String format(String time) {
        String[] split = time.split(":");
        String H = split[0];
        String M = split[1];
        H = H.length() == 2 ? H : "0" + H;
        M = M.length() == 2 ? M : "0" + M;
        return H + ":" + M;
    }

    public static void main(String[] args) {
        System.out.println("20:12" + "得到" + fun("20:12"));
        System.out.println("23:59" + "得到" + fun("23:59"));
        System.out.println("12:58" + "得到" + fun("12:58"));
        System.out.println("18:52" + "得到" + fun("18:52"));
        System.out.println("23:52" + "得到" + fun("23:52"));
        System.out.println("09:17" + "得到" + fun("09:17"));
        System.out.println("07:08" + "得到" + fun("07:08"));
        System.out.println("22:59" + "得到" + fun("22:59"));
        System.out.println("22:39" + "得到" + fun("22:39"));
//        20:12得到20:20
//        23:59得到22:22
//        12:58得到15:11
//        18:52得到18:55
//        23:52得到23:53
//        09:17得到09:19
//        07:08得到08:00
//        22:59得到22:22
//        22:39得到23:22
    }

}
