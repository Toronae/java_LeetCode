package lzf.Hw;

public class Code_25_10 {
    public static void main(String[] args) {
        String input = "abc123ABC";
        int n = input.length();
        int left =0 ,right =0;
        int res =0;
        while (right < n) {
            if (!Character.isDigit(input.charAt(right))){
                res = Math.max(res,right-left);
                right++;
                left = right;

            }else {
                right++;
            }
        }
        System.out.println(res+1);
    }
}
