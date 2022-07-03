package lzf.DynamicProgramming;

/**
 * 回文
 * 统计并返回这个字符串中 回文子串 的数目
 */
public class Code_647 {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(new Code_647().countSubstrings(s));
    }
    public int countSubstrings(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) {
            return 0;
        }
        //dp[i][j]：s字符串下标i到下标j的字串是否是一个回文串，即s[i, j]
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                //当两端字母一样时，才可以两端收缩进一步判断
                if (s.charAt(i) == s.charAt(j)) {
                    //i++，j--，即两端收缩之后i,j指针指向同一个字符或者i超过j了,必然是一个回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //否则通过收缩之后的字串判断
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {//两端字符不一样，不是回文串
                    dp[i][j] = false;
                }
            }
        }
        //遍历每一个字串，统计回文串个数
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
