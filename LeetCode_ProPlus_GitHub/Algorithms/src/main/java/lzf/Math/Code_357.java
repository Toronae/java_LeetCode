package lzf.Math;

public class Code_357 {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Code_357().countNumbersWithUniqueDigits(n));
    }
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}
