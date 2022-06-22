package lzf.Hw;

import java.util.*;

/**
 * https://blog.csdn.net/qq_34465338/article/details/124489533
 * 关联子串
 */
public class Code_25_2 {
    static Set<String> res = new HashSet();
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "efghicabiii";
        permutation(str1);
        for (String temp : res) {
            System.out.println(temp);
            if(str2.contains(temp)){
                int n = str2.indexOf(temp);
                System.out.println(n);
            }
        }
    }

    public static String[] permutation(String s) {
        backtrack(s.toCharArray(),new StringBuilder(), new boolean[s.length()]);
        return res.toArray(new String[0]);

    }

    // 回溯函数
    public static void backtrack(char[] ch, StringBuilder sb, boolean[] visitid){
        // 终止条件
        if(sb.length() == ch.length){
            res.add(sb.toString());
            return;
        }
        // 选择列表
        for(int i = 0; i < ch.length; i++){
            // 剪枝，如果当前位置的元素已经使用过，则跳过进入下一个位置
            if(visitid[i]) {
                continue;
            }
            // 做出选择
            sb.append(ch[i]);
            // 更新标记
            visitid[i] = true;
            // 进入下层回溯
            backtrack(ch,sb,visitid);
            // 撤销选择
            sb.deleteCharAt(sb.length()-1);
            visitid[i] = false;
        }
    }
}
