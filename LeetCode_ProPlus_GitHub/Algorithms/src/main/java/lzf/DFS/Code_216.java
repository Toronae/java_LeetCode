package lzf.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_216 {
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(new Code_216().combinationSum3(k,n));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,k,1,0);
        return res;
    }
    private void backTracking(int targetSum, int k, int startIndex, int sum ) {
        //减枝
        if (sum > targetSum) {
            return;
        }
        if (path.size() == k){
            if (sum == targetSum) {
                res.add(new ArrayList<>(path));
                return;
            }
        }
        //减枝
        for (int i = startIndex; i <= 9-(k-path.size())+1; i++) {
            path.add(i);
            sum += i;
            //回溯
            backTracking(targetSum,k,i+1,sum);
            path.removeLast();
            sum -= i;
        }
        
    }
}
