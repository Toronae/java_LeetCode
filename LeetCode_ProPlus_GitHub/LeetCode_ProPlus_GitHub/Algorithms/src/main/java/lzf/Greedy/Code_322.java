package lzf.Greedy;

import java.util.Arrays;

public class Code_322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(new Code_322().coinChange(coins,amount));
    }
    int minCount=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        //对coins从大到小排序
        Arrays.sort(coins);
        dfs(coins,amount,0,coins.length-1);
        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }
        return minCount;
    }
    public void dfs (int[] coins,int amount,int selectedCount,int startIndex) {
        //如果amount==0则终止
        if (amount==0) {
            if (selectedCount < minCount) {
                minCount = selectedCount;
            }
            return;
        }
        if (startIndex<0) {
            return;
        }
        //计算当前硬币最多能使用多少次
        int maxCount = amount / coins[startIndex];
        //从选择列表[0,maxCount]中选择,然后递归到下一个硬币
        for (int i=maxCount;i>=0 && i+selectedCount < minCount ;i--) {
            //选择i个该硬币后剩余的额度
            int resAmount = amount - i*coins[startIndex];
            //drill down
            dfs(coins,resAmount,selectedCount+i,startIndex-1);
            //这里无需显示的撤销选择,for循环继续走选择下一个就相当于在回溯了,我们无需记走过的路径和每种走法,我们只是在走的过程中记步数。
        }
    }
}
