package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124579505?spm=1001.2014.3001.5502
 * 小组中每位都有一张卡片，卡片上是6位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。
 * 输入描述:
 * “,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多25个人
 * 输出描述:
 * 最大的数字字符串
 * 示例1
 * 输入
 * 22,221
 * 输出
 * 22221
 * 示例2
 * 输入
 * 4589,101,41425,9999，9
 * 输出
 * 9999458941425101
 */
public class Code_组成最大数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        //首位排序后，在对次位进行排序
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            int ch = Integer.parseInt(String.valueOf(split[i].charAt(0)));
            List<String> def = map.getOrDefault(ch, new ArrayList<>());
            def.add(split[i]);
            map.put(ch,def);
        }
        //到过来输出
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >0 ; i--) {
            if (map.containsKey((Object) i )) {
                List<String> strings = map.get(i);
                sb.append(getChangeList(strings));
            }
        }
        System.out.println(sb);
    }
    //9,99,91,98,991,905,9
    //9,99,991,98,91,905
    //思路转为拿出一个数，比较后面有没有比他大的数，有则当前数放到最后，没有则直接拼接
    private static String getChangeList(List<String> list){
        LinkedList<String> linkList = new LinkedList<>(list);
        StringBuilder sb = new StringBuilder();
        while (linkList.size() > 0){
            String tem = linkList.get(0);
            boolean flag = true;
            if (tem.length() != 1){
                for (int i = 1; i < linkList.size(); i++) {
                    if (compareMax(tem,linkList.get(i))){//tem不是当前最大值
                        linkList.remove(0);
                        linkList.addLast(tem);
                        flag = false;
                        break;
                    }
                }
            }//没有比当前值更大的，直接删掉当前值
            if (flag){
                sb.append(tem);
                linkList.remove(0);
            }
        }
        return sb.toString();
    }
    //98,99,901,902,998
    private static boolean compareMax(String idx0,String idx1){
        int idx1Length = idx0.length();
        int idx2Length = idx1.length();
        int length =Math.min(idx1Length,idx2Length);
        for (int i = 1; i < length; i++) {
            int i1 = Integer.parseInt(String.valueOf(idx0.charAt(i)));
            int i2 = Integer.parseInt(String.valueOf(idx1.charAt(i)));
            if (i1 != i2){
                return i2 - i1 > 0;
            }
        }
        return idx2Length == length;
    }
}
