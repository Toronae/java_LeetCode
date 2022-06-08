package lzf.Stack;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.Deque;
import java.util.LinkedList;

public class Code_402 {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(new Code_402().removeKdigits(num,k));
    }
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k>0 &&deque.peekLast() >digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" :res.toString();
    }
}
