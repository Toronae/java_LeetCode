package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124558394?spm=1001.2014.3001.5502
 * 给定两个字符集合，一个为全量字符集，一个为已占用字符集。已占用的字符集中的字符不能再使用，要求输出剩余可用字符集。
 * 输入描述:
 * 1、输入为一个字符串，一定包含@符号。@前的为全量字符集，@后的字为已占用字符集。
 * 2、已占用字符集中的字符一定是全量字符集中的字符。字符集中的字符跟字符之间使用英文逗号分隔。
 * 3、每个字符都表示为字符加数字的形式，用英文冒号分隔，比如a:1，表示1个a字符。
 * 4、字符只考虑英文字母，区分大小写，数字只考虑正整形，数量不超过100。
 * 5、如果一个字符都没被占用，@标识仍然存在，例如a:3,b:5,c:2@
 * 输出描述:
 * 输出可用字符集，不同的输出字符集之间回车换行。
 * 注意，输出的字符顺序要跟输入一致。不能输出b:3,a:2,c:2
 * 如果某个字符已全被占用，不需要再输出。
 * 示例1
 * 输入
 * a:3,b:5,c:2@a:1,b:2
 * 输出
 * a:2,b:3,c:2
 * 说明
 * 全量字符集为3个a，5个b，2个c。
 * 已占用字符集为1个a，2个b。
 * 由于已占用字符不能再使用，因此，剩余可用字符为2个a，3个b，2个c。
 * 因此输出a:2,b:3,c:2
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124558394
 */
public class Code_字符串统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split("@");
        if (split.length<2){
            System.out.println(split[0]);
            return;
        }
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        String[] full = split[0].split(",");
        for (int i = 0; i < full.length; i++) {
            String[] dan = full[i].split(":");
            list.add(dan[0]);
            map.put(dan[0],Integer.parseInt(dan[1]));
        }
        String[] used = split[1].split(",");
        for (int i = 0; i < used.length; i++) {
            String[] dan = used[i].split(":");
            int fullCount = map.get(dan[0]);
            if (fullCount > Integer.parseInt(dan[1])){
                map.put(dan[0],fullCount - Integer.parseInt(dan[1]));
            }else {
                map.remove(dan[0]);
                list.remove(dan[0]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String tem = list.get(i);
            int left = map.get(tem);
            sb.append(tem).append(":").append(left).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
