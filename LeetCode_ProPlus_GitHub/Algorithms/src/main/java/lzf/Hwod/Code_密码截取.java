package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/nameix/article/details/52251841
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化
 * ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
 * Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 输入描述:
 * 输入一个字符串
 * 输出描述:
 * 返回有效密码串的最大长度
 * 示例1
 * 输入
 * ABBA
 * 输出
 * 4
 */
public class Code_密码截取 {

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            System.out.println(maxHuiwen(s));
        }sc.close();}
    private static int maxHuiwen(String s){
        if(s.length()==0||s==null){return 0;}
        int max=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(huiwen(s.substring(i,j+1))){
                        max=max>(j+1-i)?max:(j+1-i);
                    }
                    break;
                }
            }
        }
        return max;
    }
    private static boolean huiwen(String s){
        boolean bol=false;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)==s.charAt(s.length()-i-1)){bol=true;}
        }
        return bol;
    }
}
