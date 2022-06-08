package lzf.DFS;

import java.util.ArrayList;
import java.util.List;

public class Code_17 {
    public static void main(String[] args) {
        String digits = "23";
        //System.out.println(digits.charAt(1));
        System.out.println(new Code_17().letterCombinations(digits));
    }

    // 设置全局列表存储最后的结果
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return res;
    }

    // 每次迭代获取一个字符串，会设计大量的字符串拼接，所有这里选择更为高效的StringBuild
    StringBuilder temp = new StringBuilder();

    // 比如digits如果为“23”，num为0，则str表示2对应的abc
    private void backTracking(String digits, String[] numString, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            res.add(temp.toString());
            return;
        }
        // str表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
