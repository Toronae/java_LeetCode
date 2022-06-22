package lzf.Stack;

import java.util.Stack;

public class Code_20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new Code_20().isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
