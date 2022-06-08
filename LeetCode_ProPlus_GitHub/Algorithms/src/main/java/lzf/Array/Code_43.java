package lzf.Array;

import java.math.BigInteger;

public class Code_43 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new Code_43().multiply(num1,num2));
    }
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1<0||len2<0) {
            return "";
        }
        //存储乘积
        int[] res = new int[len1+len2];
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int x = num1.charAt(i)-'0';
                int t = (num2.charAt(j)-'0')*x;
                //先加上低位判断进位
                t += res[i+j+1];
                res[i+j] += t/10;
                res[i+j+1] = t%10;
            }
        }
        StringBuffer s = new StringBuffer();
        int idx = 0;
        //去掉前导0
        while(idx<len1+len2-1&&res[idx]==0) {
            idx++;
        }
        for(;idx<len1+len2;idx++){
            s.append(res[idx]);
        }
        return s.toString();
    }

    /*public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }*/

    //
    /*public String multiply(String num1, String num2) {
        BigInteger n = BigInteger.valueOf(Long.parseLong(num1));
        BigInteger m = BigInteger.valueOf(Long.parseLong(num2));
        return String.valueOf(n.multiply(m));
    }*/
}
