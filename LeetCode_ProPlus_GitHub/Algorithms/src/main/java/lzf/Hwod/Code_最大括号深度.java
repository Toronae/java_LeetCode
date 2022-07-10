package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124579505?spm=1001.2014.3001.5502
 * 现有一字符串仅由 ‘(’，’)’，’{’，’}’，’[’，’]'六种括号组成。
 * 若字符串满足以下条件之一，则为无效字符串：
 * ①任一类型的左右括号数量不相等；
 * ②存在未按正确顺序（先左后右）闭合的括号。
 * 输出括号的最大嵌套深度，若字符串无效则输出0。
 * 0≤字符串长度≤100000
 * 输入描述:
 * 一个只包括 ‘(’，’)’，’{’，’}’，’[’，’]'的字符串
 * 输出描述:
 * 一个整数，最大的括号深度
 * 示例1
 * 输入
 * []
 * 输出
 * 1
 * 说明
 * 有效字符串，最大嵌套深度为1
 * 示例2
 * 输入
 * ([]{()})
 * 输出
 * 3
 * 说明
 * 有效字符串，最大嵌套深度为3
 * 示例3
 * 输入
 * (]
 * 输出
 * 0
 * 说明
 * 无效字符串，有两种类型的左右括号数量不相等
 * 示例4
 * 输入
 * ([)]
 * 输出
 * 0
 * 说明
 * 无效字符串，存在未按正确顺序闭合的括号
 * 示例5
 * 输入
 * )(
 * 输出
 * 0
 * 说明
 * 无效字符串，存在未按正确顺序闭合的括号
 */
public class Code_最大括号深度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        MyStack<Character> stack = new MyStack<Character>(input.length());
        Character pop;
        int totalDeep = 0;
        int maxDeep = 0;
        for (char ch: chars) {
            switch (ch){
                case '{':
                case '[':
                case '(':
                    totalDeep++;
                    stack.pull(ch);
                    break;
                case ']':
                    pop = stack.pop();
                    if (pop != null &&  pop == '['){
                        totalDeep--;
                        break;
                    }else {
                        System.out.println(0);
                        return;
                    }
                case '}':
                    pop = stack.pop();
                    if (pop!= null &&  pop == '{'){
                        totalDeep--;
                        break;
                    }else {
                        System.out.println(0);
                        return;
                    }
                case ')':
                    pop = stack.pop();
                    if (pop != null && pop == '('){
                        totalDeep--;
                        break;
                    }else {
                        System.out.println(0);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unexpected value: " + ch);
            }
            maxDeep = Math.max(maxDeep,totalDeep);
        }
        if (stack.isEmpty()) {
            System.out.println(maxDeep);
        }else {
            System.out.println(0);
        }


    }
    private static class MyStack<Item>{
        public Item[] arr;
        private int size;

        public MyStack(int cap) {//由用户来初始化长度
            arr = (Item[]) new Object[cap];
        }

        //弹出栈顶
        public Item pop(){
            if (isEmpty()) {
                return null;
            }
            Item item = arr[--size];
            arr[size] = null;
            return item;

        }
        //入栈 长度由初始化保证，不考虑扩容
        public void pull(Item item){
            arr[size++] = item;
        }

        public boolean isEmpty(){
            return size == 0;
        }
    }
}
