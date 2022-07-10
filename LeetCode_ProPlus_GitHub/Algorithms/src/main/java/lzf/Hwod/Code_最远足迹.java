package lzf.Hwod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124579505?spm=1001.2014.3001.5502
 * 某探险队负责对地下洞穴进行探险。探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。探索工作结束后，探险队需要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
 * 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中0<x<1000，0<y<1000。同时存在非法坐标，如(01,1)、(1,01)，(0,100)属于非法坐标。
 * 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为：xx+yy。
 * 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 * 若记录仪中的坐标都不合法，输出总部坐标（0,0）。
 * 备注：不需要考虑双层括号嵌套的情况，比如sfsdfsd((1,2))。
 * 输入描述:
 * 字符串，表示记录仪中的数据。
 * 如：ferga13fdsf3(100,200)f2r3rfasf(300,400)
 * 输出描述:
 * 字符串，表示最远足迹到达的坐标。
 * 如： (300,400)
 * 示例1
 * 输入
 * ferg(3,10)a13fdsf3(3,4)f2r3rfasf(5,10)
 * 输出
 * (5,10)
 * 说明
 * 记录仪中的合法坐标有3个： (3,10)， (3,4)， (5,10)，其中(5,10)是相距总部最远的坐标， 输出(5,10)。
 * 示例2
 * 输入
 * asfefaweawfaw(0,1)fe
 * 输出
 * (0,0)
 * 说明
 * 记录仪中的坐标都不合法，输出总部坐标（0,0）
 */
public class Code_最远足迹 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> list = new ArrayList<>();
        boolean flag = input.contains("(");
        while (flag){
            int i1 = input.indexOf("(");
            int i2 = input.indexOf(")");
            list.add(input.substring(i1+1,i2));
            input = input.substring(i2+1);
            flag = input.contains("(");
        }
        //分割数据
        int xi = 0 ;
        int yi = 0;
        int maxi = 0;
        for (int i = 0; i < list.size(); i++) {//0<x<1000，0<y<1000
            //数据不能是开头
            String[] split = list.get(i).split(",");
            if (split[0].startsWith("0") || split[1].startsWith("0")){//数据忽略
                continue;
            }
            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            if (x1 <= 0 || x1 >=1000 || y1 <= 0  || y1 >= 1000){
                continue;
            }
            if (x1 * x1 + y1 * y1 > maxi){
                maxi = x1 * x1 + y1 * y1;
                xi = x1;
                yi = y1;
            }
        }
        System.out.println("("+ xi + ","  +yi +")");
    }
}
