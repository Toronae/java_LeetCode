package lzf.Hwod;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * （200）
 * http://dl2.kerwin.cn:8063/csdn/key/article-qq_34465338-124446240/auth/1657355467-2022110616310735-0-c154f008ce8a5bbab79b573aedd0c71c
 * LISP语言唯一的语法就是括号要配对。
 * 形如 (OP P1 P2 ...)，括号内元素由单个空格分割。
 * 其中第一个元素OP为操作符，后续元素均为其参数，参数个数取决于操作符类型
 * 注意：参数 P1, P2 也有可能是另外一个嵌套的 (OP P1 P2 ...)
 * 当前OP类型为 add / sub / mul / div（全小写），分别代表整数的加减乘除法
 * 简单起见，所有 OP 参数个数均为 2
 * 举例:
 * - 输入：(mul 3 -7) 输出：-21
 * - 输入：(add 1 2) 输出：3
 * - 输入：(sub (mul 2 4) (div 9 3)) 输出：5
 * - 输入：(div 1 0) 输出：error
 * 题目涉及数字均为整数，可能为负；不考虑32位溢出翻转，计算过程中也不会发生32位溢出翻转
 * 除零错误时，输出 "error"，除法遇除不尽，向下取整，即 3/2 = 1
 * 输入描述:
 * 输入为长度不超过512的字符串，用例保证了无语法错误
 * 输出描述:
 * 输出计算结果或者“error”
 * 示例1
 * 输入
 * (div 12 (sub 45 45))
 * 输出
 * error
 * 说明
 * 45减45得0，12除以0为除零错误，输出error
 * 示例2
 * 输入
 * (add 1 (div -7 3))
 * 输出
 * -2
 * 说明
 * -7除以3向下取整得-3，1加-3得-2
 * 解题思路
 * 看到这种计算题，就要想到使用栈。
 * 1、通过空格对输入的字符串进行分割。
 * 2、对步骤1获取的数组进行遍历。将数字和符号放入各自的数组中。
 * 对于符号的判断，我们使用了比较取巧的方法：包含a的为加法，包含b的为减法，包含m的为乘法，包含v的为除法
 * 3、如果碰到”）“，则开始进行计算，从数字数组中取最后面的两个数字，从符号数组中取最后面的符号进行计算。
 */
public class Code_仿LISP运算 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //(sub (mul 2 4) (div 9 3))
        // add / sub / mul / div

        String[] s = sc.nextLine().split(" ");  //输入可以按照空格分割长数组

        Deque<String> fuhao = new ArrayDeque<>();   //符合堆栈
        Deque<Integer> num = new ArrayDeque<>();    //数字堆栈
        boolean isE = false;    //除0表示计算错误

        for(int i=0;i<s.length;i++){
            if(s[i].contains("a")){ //如果包含a则表示+
                fuhao.push("+");
            }else if(s[i].contains("b")){   //如果包含b则表示-
                fuhao.push("-");
            }else if(s[i].contains("m")){   //如果包含m则表示*
                fuhao.push("*");
            }else if(s[i].contains("v")){   //如果包含v则表示/
                fuhao.push("/");
            }else if(s[i].contains(")")){   //如果包含)则表示需要进行计算
                String temp = "";   //）前面的数字
                for(int j=0;j<s[i].length();j++){   //包含）的字符串需要筛选出数字
                    if(s[i].charAt(j)==')'){    //考虑到都有多个）,需要计算多次
                        if(temp.length()!=0){   //如果是0表示已经计算过一次
                            num.push(Integer.parseInt(temp));   //将数字放入数堆栈中
                            temp = "";  //需要置空（这一步很关键）
                        }
                        int b = num.pop();  //第二个数
                        int a = num.pop();  //第一个数
                        String f = fuhao.pop(); //符号
                        if(f=="/" && b==0){ //除数为0则退出，输出error
                            isE = true;
                            break;
                        }else {
                            //将计算完的数据放入数堆栈中进入下次的计算
                            num.push(jisuan(a,b,f));
                        }
                    }else {
                        //不到）都表示数字（主要考虑到多位数）
                        temp +=s[i].charAt(j);
                    }
                }
            }else {
                num.push(Integer.parseInt(s[i]));
            }
            if(isE){break;}
        }

        if(isE){
            System.out.println("error");
        }else {
            System.out.println(num.peek());
        }
    }

    public static int jisuan(int a,int b,String f){
        switch (f){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return Math.floorDiv(a,b);  //向下取整
        }
        return 0;
    }
}
