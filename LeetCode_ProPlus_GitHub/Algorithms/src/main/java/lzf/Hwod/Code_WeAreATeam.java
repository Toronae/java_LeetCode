package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124643796?spm=1001.2014.3001.5502
 * 总共有n个人在机房，每个人有一个标号（1 <= 标号 <=n），他们分成了多个团队，需要你根据收到的m条消息判定指定的两个人是否在一个团队中，具体的：
 * 1、消息构成为：a b c，整数a、b分别代表了两个人的标号，整数c代表指令。
 * 2、c0代表a和b在一个团队内。
 * 3、c1代表需要判定a和b的关系，如果a和b是一个团队，输出一行“we are a team”，如果不是，输出一行“we are not a team”。
 * 4、c为其它值，或当前行a或b超出1~n的范围，输出“da pian zi”。
 * 输入描述:
 * 1、第一行包含两个整数n, m(1 <= n, m <= 100000)，分别表示有n个人和m条消息。
 * 2、随后的m行，每行一条消息，消息格式为:a b c (1 <= a, b <= n, 0 <= c <= 1)。
 * 输出描述:
 * 1、c==1时，根据a和b是否在一个团队中输出一行字符串，在一个团队中输出“we are a team”，不在一个团队中输出“we are not a team”。
 * 2、c为其他值，或当前行a或b的标号小于1或者大于n时，输出字符串“da pian zi”。
 * 3、如果第一行n和m的值超出约定的范围时，输出字符串"NULL"。
 * 示例1
 * 输入
 * 5 6
 * 1 2 0
 * 1 2 1
 * 1 5 0
 * 2 3 1
 * 2 5 1
 * 1 3 2
 * 输出
 * we are a team
 * we are not a team
 * we are a team
 * da pian zi
 * 说明
 * 第2行定义了1和2是一个团队
 * 第3行要求进行判定，输出"we are a team"
 * 第4行定义了1和5是一个团队，自然2和5也是一个团队
 * 第5行要求进行判定，输出"we are not a team"
 * 第6行要求进行判定，输出"we are a team"
 * 第7行c为其它值，输出"da pian zi"
 */
public class Code_WeAreATeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nms = sc.nextLine().split(" ");
        int nums = Integer.parseInt(nms[0]);
        int mes = Integer.parseInt(nms[1]);
        List<Set<Integer>> lists = new ArrayList<>();
        List<String> waitForVerify = new ArrayList<>();
        for (int i = 0; i < mes; i++) {
            String real = sc.nextLine();
            String[] rels = real.split(" ");
            int i1 = Integer.parseInt(rels[0]);
            int i2 = Integer.parseInt(rels[1]);
            int i3 = Integer.parseInt(rels[2]);
            if (i3 != 0){
                waitForVerify.add(real);
            }else {
                boolean flag = false;
                for (int j = 0; j < lists.size(); j++) {
                    Set<Integer> set = lists.get(j);
                    if (set.contains(i1) || set.contains(i2)){
                        set.add(i1);
                        set.add(i2);
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    Set<Integer> set = new HashSet<>();
                    set.add(i1);
                    set.add(i2);
                    lists.add(set);
                }
            }
        }
        //判断非0的关系
        for (int i = 0; i < waitForVerify.size(); i++) {
            String[] reli = waitForVerify.get(i).split(" ");
            int i1 = Integer.parseInt(reli[0]);
            int i2 = Integer.parseInt(reli[1]);
            int i3 = Integer.parseInt(reli[2]);
            if (i3 != 1){
                System.out.println("da pian zi");
                continue;
            }
            for (int j = 0; j < lists.size(); j++) {
                Set<Integer> set = lists.get(j);
                if (set.contains(i1) && set.contains(i2)){
                    System.out.println("we are a team");
                }else {
                    System.out.println("we are not a team");
                }
            }
        }
    }
}
