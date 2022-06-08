package lzf.Array;

import java.util.*;

public class Code_316 {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new Code_316().removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] lastInx = new int[26];
        for (int i = 0; i < chars.length ; i++) {
            lastInx[chars[i] - 'a'] = i; //记录每个元素最后一次出现的位置
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26]; //某一个字符是否在栈中出现
        for (int i = 0; i < chars.length; i++) {
            if (visited[chars[i] - 'a']) { //如果出现舍弃当前字符
                continue;
            }
            //当前字符在栈顶元素之前，且栈顶元素在后面还有
            while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastInx[stack.peekLast() - 'a'] > i) {
                Character c = stack.removeLast();  //移除栈顶元素
                visited[c - 'a'] = false; //表示该字符没有在栈中出现
            }
            stack.addLast(chars[i]);
            visited[chars[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        return sb.toString();
    }

    /*public String removeDuplicateLetters(String s){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c=s.charAt(i);
            if(stack.contains(c))
                continue;
            while(!stack.isEmpty()&&stack.peek()>c&&s.indexOf(stack.peek(),i)!=-1)
                stack.pop();
            stack.push(c);
        }
        char[] chars=new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i]=stack.get(i);
        }
        return new String(chars);
    }*/

    /*public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Set<Character> ch = new TreeSet<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length;i++){
            ch.add((chars[i]));
        }
        Iterator it = ch.iterator();
        while (it.hasNext()){
            result.append(it.next());
        }
        return String.valueOf(result);
    }*/
}
