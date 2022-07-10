package lzf.Hw;

/**
 * 计价器跳4的问题，靠谱的车
 * https://blog.csdn.net/qq_37905259/article/details/119183866
 */
public class Code_25_20 {
    public static void main(String[] args) {
        int n = 25;
        int ans = n, temp = 0, k = 0, j = 1;
        while (n > 0) {
            if (n % 10 > 4) {
                temp += (n % 10 - 1) * k + j;
            } else {
                temp += (n % 10) * k;
            }
            k = k * 9 + j;
            j *= 10;
            n /= 10;
        }
        System.out.println(ans - temp);
    }
}
