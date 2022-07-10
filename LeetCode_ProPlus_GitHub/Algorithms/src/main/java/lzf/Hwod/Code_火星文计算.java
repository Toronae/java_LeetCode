package lzf.Hwod;

import java.util.Scanner;

/**
 * （200）
 * https://blog.csdn.net/csfun1/article/details/124509176?spm=1001.2014.3001.5502
 * 已知火星人使用的运算符号为#;KaTeX parse error: Expected 'EOF', got '#' at position 17: …其与地球人的等价公式如下: x#̲y=2*x+3*y+4 xy=3x+y+2
 * 1、其中x、y是无符号整数
 * 2、地球人公式按C语言规则计算
 * 3、火星人公式中，KaTeX parse error: Expected 'EOF', got '#' at position 7: 的优先级高于#̲，相同的运算符，按从左到右的顺…）组成的计算表达式。例如：123#4$5#67$78。
 * 1、用例保证字符串中，操作数与操作符之间没有任何分隔符。
 * 2、用例保证操作数取值范围为32位无符号整数。
 * 3、保证输入以及计算结果不会出现整型溢出。
 * 4、保证输入的字符串为合法的求值报文，例如：123#4$5#67$78
 * 5、保证不会出现非法的求值报文，例如类似这样字符串：
 * #4$5 //缺少操作数
 * 4$5# //缺少操作数
 * 4#$5 //缺少操作数
 * 4 $5 //有空格
 * 3+4-56/7 //有其它操作符
 * 12345678987654321$54321 //32位整数计算溢出
 * 输出描述:
 * 根据输入的火星人字符串输出计算结果（结尾不带回车换行）
 * 示例1
 * 输入
 * 7#6$5#12
 * 输出
 * 226
 * 说明
 * 示例：
 * 7#6$5#12
 * =7#(18+5+2)#12
 * =7#25#12
 * =(14+75+4)#12
 * =93#12
 * =293+312+4
 * =226
 */
public class Code_火星文计算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (input.contains("$") || input.contains("#")){
            if (input.contains("$")) {//字符串左取右不取 7#6$5#12
                int idx = input.lastIndexOf("$");
                int leftStart = changeInput(input, idx, -1);
                int op1 = Integer.parseInt(input.substring(leftStart,idx));
                int rightEnd = changeInput(input, idx, +1);
                int op2 = Integer.parseInt(input.substring(idx +1,rightEnd));
                int res = calcStar('$', op1, op2);
                input = input.substring(0,leftStart) + res + input.substring(rightEnd);
            }else {
                if (input.contains("#")) {
                    int idx = input.indexOf("#",0);
                    int leftStart = changeInput(input, idx, -1);
                    int op1 = Integer.parseInt(input.substring(leftStart,idx));
                    int rightEnd = changeInput(input, idx, +1);
                    int op2 = Integer.parseInt(input.substring(idx +1,rightEnd));
                    int res = calcStar('#', op1, op2);
                    input = input.substring(0,leftStart) + res + input.substring(rightEnd);
                }
            }
        }
        System.out.println(input);
    }

    //opt -1表示左边的整数 1表示右边的整数 7#6$5#12 leftStart  rightEnd
    private static int changeInput(String input,int idx,int opt){
        char ch = input.charAt(idx + opt);
        while (ch >= '0' && ch<= '9'){
            if (opt>0){
                opt++;
            }else {
                opt--;
            }
            if (idx + opt >=0 && idx + opt < input.length()){
                ch = input.charAt(idx + opt);
            }else {
                break;
            }
        }
        if (opt<0){
            return opt + idx +1;
        }else {
            return opt + idx;
        }
    }

    private static int calcStar(char ch, int op1,int op2){
        if (ch == '#'){
            return op1 * 2 + op2 * 3 + 4;
        }else {
            return 3 * op1 + op2 + 2;
        }
    }
}
