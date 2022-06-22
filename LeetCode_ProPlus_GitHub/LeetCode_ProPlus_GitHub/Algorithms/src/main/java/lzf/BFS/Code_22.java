package lzf.BFS;

import java.util.ArrayList;
import java.util.List;

public class Code_22 {
    public static void main(String[] args) {
        int n= 3;
        System.out.println(new Code_22().generateParenthesis(n));
    }

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTracking(n,n,"");
        return res;
    }

    private void backTracking(int left, int right, String curStr) {
        // 左右括号都不剩余了，递归终止
        if (left ==0 && right == 0) {
            res.add(curStr);
            return;
        }
        // 如果左括号还剩余的话，可以拼接左括号
        if (left > 0 ) {
            backTracking(left-1,right,curStr+"(");
        }
        // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
        if (right>left) {
            backTracking(left,right-1,curStr+")");
        }
    }
}
