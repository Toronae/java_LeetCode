package lzf.Math;

public class Code_202 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(new Code_202().isHappy(n));
    }
    //判断循环就用快慢指针
    public int squareSum(int n) {
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        };
        return slow == 1;
    }

}
