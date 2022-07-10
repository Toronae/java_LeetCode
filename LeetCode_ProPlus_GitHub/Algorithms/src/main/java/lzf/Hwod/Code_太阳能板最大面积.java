package lzf.Hwod;

import java.util.Scanner;

/**
 * https://blog.csdn.net/csfun1/article/details/124544351?spm=1001.2014.3001.5502
 * 给航天器一侧加装长方形或正方形的太阳能板（图中的红色斜线区域），需要先安装两个支柱（图中的黑色竖条），再在支柱的中间部分固定太阳能板。但航天器不同位置的支柱长度不同，太阳能板的安装面积受限于最短一侧的那根支柱长度。如图：
 * 现提供一组整形数组的支柱高度数据，假设每根支柱间距离相等为1个单位长度，计算如何选择两根支柱可以使太阳能板的面积最大。
 * 输入描述:
 * 10,9,8,7,6,5,4,3,2,1
 * 注：支柱至少有2根，最多10000根，能支持的高度范围1~10^9的整数。柱子的高度是无序的，例子中递减只是巧合。
 * 输出描述:
 * 可以支持的最大太阳能板面积：（10米高支柱和5米高支柱之间）
 * 25
 * 示例1
 * 输入
 * 10,9,8,7,6,5,4,3,2,1
 * 输出
 * 25
 * 备注:
 * 10米高支柱和5米高支柱之间宽度为5，高度取小的支柱高也是5，面积为25。任取其他两根支柱所能获得的面积都小于25。所以最大的太阳能板面积为25。
 */
public class Code_太阳能板最大面积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] highsStr = scanner.nextLine().split(",");
        int highLen = highsStr.length;
        long[] highs = new long[highLen];
        for (int i = 0; i < highLen; i++) {
            highs[i] = Long.parseLong(highsStr[i]);
        }

        long res = 0, p1, p2, high, width;
        for (int i = 0; i < highLen; i++) {
            for (int j = 0; j < highLen; j++) {
                p1 = highs[i];
                p2 = highs[j];
                // 高 = 短柱子的高
                high = Math.min(highs[i], highs[j]);

                // 宽 = 高柱子的高 - 短柱子的高
                width = Math.abs(p1 - p2);
                res = Math.max(res, high * width);
            }
        }
        System.out.println(res);
    }
}
