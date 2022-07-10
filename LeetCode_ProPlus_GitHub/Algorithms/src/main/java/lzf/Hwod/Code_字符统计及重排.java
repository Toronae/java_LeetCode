package lzf.Hwod;

import java.util.*;

/**
 * https://blog.csdn.net/csfun1/article/details/124579505?spm=1001.2014.3001.5502
 * 给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的次数，并按照字母出现次数从大到小的顺序输出各个字母及其出现次数。如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
 * 输入描述:
 * 输入一行，为一个仅包含字母的字符串。
 * 输出描述:
 * 按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的分号；字母和次数间用英文冒号分隔。
 * 示例1
 * 输入
 * xyxyXX
 * 输出
 * x:2;y:2;X:2;
 * 说明
 * 每个字符出现的个数都是2，故x排在y之前，而小写字母x在X之前
 * 示例2
 * 输入
 * abababb
 * 输出
 * b:4;a:3;
 * 说明
 * b的出现个数比a多，故b排在a之前
 */
public class Code_字符统计及重排 {
    public static void main(String[] args) {
        List<Word> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //存
        Map<Character,Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            Word word = new Word(1,ch);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                list.get(index).count++;
            }else {
                map.put(ch,idx++);
                list.add(word);
            }
        }
        //取
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Word word = list.get(i);
            sb.append(word.ch).append(":").append(word.count).append(",");
        }
        sb.deleteCharAt(sb.length() -1).append(";");
        System.out.println(sb);

    }

    private static class Word implements Comparable<Word>{
        private int count;
        private char ch;

        public Word(int count, Character ch) {
            this.count = count;
            this.ch = ch;
        }

        @Override
        public int compareTo(Word wo) {
            char o1 = wo.ch;
            char o2 = this.ch;
            if (wo.count!= this.count){
                return wo.count - this.count;
            }
            if ((o1 >= 'a' && o2>= 'a') || (o1 <= 'Z' && o2<= 'Z')){//相同时正序排
                return o2 - o1;
            }else {//逆序排
                return o1 - o2;
            }
        }

        @Override
        public boolean equals(Object obj) {
            Word wo = (Word) obj;
            return this.ch == wo.ch;
        }
    }
}
