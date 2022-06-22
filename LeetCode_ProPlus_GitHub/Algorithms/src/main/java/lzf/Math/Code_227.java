package lzf.Math;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Code_227 {
    public static void main(String[] args) {
        String s = "1+1";
        System.out.println(new Code_227().calculate(s));
    }
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    //方法二
    //对于表达式求值这类问题，我们维护两个栈，一个num栈用来记录数字，
    // 一个op栈用来记录操作符，遍历表达式，遇到操作符时进行数的相应计算。
    static Stack<Integer> num = new Stack<Integer>();
    static Stack<Character> op = new Stack<Character>();
    static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    static void eval()
    {
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int r = 0;
        if(c == '+') {
            r = a + b;
        } else if(c == '-') {
            r = a - b;
        } else if(c == '*') {
            r = a * b;
        } else {
            r = a / b;
        }
        num.add(r);
    }
    public int calculate1(String s) {
        s = '0' + s; // 对开头是负数的处理
        map.put('+', 1);   //定义运算符的优先级
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        for(int i = 0; i < s.length();i ++)
        {
            char c = s.charAt(i);
            if(c == ' ') continue;  //跳过空格
            if(c >= '0' && c <= '9')  //c是数字,读取一个连续的数字
            {
                int x = 0, j = i;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9')
                {
                    x = x * 10 + s.charAt(j) - '0';
                    j ++;
                }
                i = j - 1;
                num.add(x);
            }
            else  //c是操作符
            {     //op栈非空并且栈顶操作符优先级大于等于当前操作符c的优先级，进行eval()计算
                while(!op.isEmpty() && map.get(op.peek()) >= map.get(c)) {
                    eval();
                }
                op.add(c);
            }
        }
        while(!op.isEmpty()) {
            eval();
        }
        return num.pop();
    }

}
