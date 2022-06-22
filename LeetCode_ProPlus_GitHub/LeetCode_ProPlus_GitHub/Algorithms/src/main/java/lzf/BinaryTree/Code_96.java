package lzf.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class Code_96 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Code_96().numTrees(n));
    }

    // 递归法改进版
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (n == 0 ||n==1){
            return 1;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i-1);
            int rightNum = numTrees(n-i);
            count += leftNum*rightNum;
        }
        map.put(n,count);
        return count;
    }

    // 递归法
    /*public int numTrees(int n) {
        if(n ==0 || n==1){
            return 1;
        }
        int count = 0;
        for(int i = 1; i <=n;i++){
            int leftNum = numTrees(i-1);
            int rightNum = numTrees(n-i);
            count += leftNum * rightNum;
        }
        return count;
    }*/


    // 动态规划
    /*public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                res[i] += res[j-1] * res[i-j];
            }
        }
        return res[n];
    }*/
}
