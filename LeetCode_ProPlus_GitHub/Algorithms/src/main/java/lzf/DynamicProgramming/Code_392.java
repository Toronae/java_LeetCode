package lzf.DynamicProgramming;

/**
 * 编辑距离
 * 判断子序列
 */
public class Code_392 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Code_392().isSubsequence(s,t));
    }
    public boolean isSubsequence(String s, String t) {
        int length1 = s.length(); int length2 = t.length();
        int[][] dp = new int[length1+1][length2+1];
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if(dp[length1][length2] == length1){
            return true;
        }else{
            return false;
        }
    }
}
