package lzf.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Code_316 {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(new Code_316().removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c=s.charAt(i);
            if(stack.contains(c)){
                continue;
            }
            while(!stack.isEmpty()&&stack.peek()>c&&s.indexOf(stack.peek(),i)!=-1){
                stack.pop();
            }
            stack.push(c);
        }
        char chars[]=new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i]=stack.get(i);
        }
        return new String(chars);
    }
}
