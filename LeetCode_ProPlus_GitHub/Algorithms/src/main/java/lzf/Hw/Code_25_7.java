package lzf.Hw;

import cn.hutool.json.JSONUtil;

/**
 * 字符串ASC码+偏移量实现
 * https://wenku.baidu.com/view/90868df7270c844769eae009581b6bd97e19bc59.html
 */
public class Code_25_7 {
    public static void main(String[] args) {
        String s = "abcde";
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < s.length(); i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i)+dp[i];
            if (temp>=97&&temp<=122){
                char ch = (char) temp;
                sb.append(ch);
            }else {
                int in = 97+(temp-97)%26;
                sb.append(in);
            }

        }
        System.out.println(sb);
    }
}
