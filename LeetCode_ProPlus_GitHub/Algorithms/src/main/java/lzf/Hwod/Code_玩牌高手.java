package lzf.Hwod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124544351?spm=1001.2014.3001.5502
 * 给定一个长度为n的整型数组，表示一个选手在n轮内可选择的牌面分数。选手基于规则选牌，请计算所有轮结束后其可以获得的最高总分数。选择规则如下：
 * 1、在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数，为其新的总分数。
 * 2、选手也可不选择本轮牌面直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，若当前轮次小于等于3（即在第1、2、3轮选择跳过轮次），则总分数置为0。
 * 3、选手的初始总分数为0，且必须依次参加每一轮。
 * 输入描述:
 * 第一行为一个小写逗号分割的字符串，表示n轮的牌面分数，1<= n <=20。
 * 分数值为整数，-100 <= 分数值 <= 100。
 * 不考虑格式问题。
 * 输出描述:
 * 所有轮结束后选手获得的最高总分数。
 * 示例1
 * 输入
 * 1,-5,-6,4,3,6,-2
 * 输出
 * 11
 * 说明
 * 总共有7轮牌面。
 * 第一轮选择该轮牌面，总分数为1。
 * 第二轮不选择该轮牌面，总分数还原为0。
 * 第三轮不选择该轮牌面，总分数还原为0。
 * 第四轮选择该轮牌面，总分数为4。
 * 第五轮选择该轮牌面，总分数为7。
 * 第六轮选择该轮牌面，总分数为13。
 * 第七轮如果不选择该轮牌面，则总分数还原到3轮1前分数，即第四轮的总分数4，如果选择该轮牌面，总分数为11，所以选择该轮牌面。
 * 因此，最终的最高总分为11。
 */
public class Code_玩牌高手 {
    public static void main(String[] args) {

        //1,-5,-6,4,3,6,-2
        //11
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        List<Integer> list = new ArrayList<>();
        List<Integer> list_total = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            int i1 = Integer.parseInt(split[i]);
            list.add(i1);
        }
        int total = 0;
        int total_y = 0; //选择负数牌面时，总的值
        int total_n = 0; //不负数牌面时，总的值
        for (int i = 0; i < list.size(); i++) {
            //正数的时候，必选择
            if (list.get(i)>=0){
                total+=list.get(i);
                list_total.add(total);
                //负数时，进行判断
            }else if(list.get(i)<0){
                //需要该负数时，总的值
                total_y = total+list.get(i);
                //不需要该负数时，总的值
                if(i-3>=0){
                    total_n = list_total.get(i-3);
                }else {
                    total_n = 0;
                }
                //判断需要和不需要负数时，哪个大就选择哪个
                total = Math.max(total_y,total_n);
                list_total.add(total);
            }
        }
        System.out.println(total);
    }
}
