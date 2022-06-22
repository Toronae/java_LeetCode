package lzf.DivideConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Code_241 {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(new Code_241().diffWaysToCompute(expression));
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return divideConquer(expression);
    }

    private List<Integer> divideConquer(String expression) {
        List<Integer> list = new ArrayList<>();
        int len = expression.length();
        if (isAllDigits(expression)) {
            list.add(Integer.parseInt(expression));
            return list;
        }
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                continue;
            }
            List<Integer> left = divideConquer(expression.substring(0,i));
            List<Integer> right = divideConquer(expression.substring(i+1,len));
            for (int l:left) {
                for (int r:right) {
                    list.add(caculate(l,r,ch));
                }
            }
        }
        return list;
    }

    private boolean isAllDigits(String string) {
        int len = string.length();
        for (int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private Integer caculate(int l, int r, char ch) {
        if (ch == '+') {
            return l + r;
        }else if (ch == '-') {
            return l-r;
        }else {
            return l*r;
        }
    }
    /*// 备忘录
    HashMap<String, List<Integer>> memo = new HashMap<>();
    // 返回字符串 expression 的任意组合计算结果
    public List<Integer> diffWaysToCompute(String expression) {
        // 查看备忘录
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 以运算符为界分割左右两半
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                // 计算所有可能的结合结果
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }

        // base case
        // 当 res 为空的时候，说明此分割块为单独的数字
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        // 将结果加入备忘录
        memo.put(expression, res);
        return res;
    }*/

}
