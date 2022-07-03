package lzf.DynamicProgramming;

/**
 * 博弈问题
 */
public class Code_877 {
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
        System.out.println(new Code_877().stoneGame(piles));
    }
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] > 0;
    }
}
