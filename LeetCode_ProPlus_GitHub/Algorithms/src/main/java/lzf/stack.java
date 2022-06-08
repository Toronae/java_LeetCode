package lzf;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class stack {
    // java 栈推荐使用方式

    Deque<Integer> stack = new ArrayDeque<Integer>();


    // 注意：Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。
    // Deque堆栈操作方法：push()、pop()、peek()。

    Deque<Integer> deque = new LinkedList<>();

    // 常规方式

    Stack<Character> stack1 = new Stack<>();

    stack stack2 = new stack();
}
