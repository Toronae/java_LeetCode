package lzf.Math;

public class Code_263 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Code_263().isUgly(n));
    }
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
