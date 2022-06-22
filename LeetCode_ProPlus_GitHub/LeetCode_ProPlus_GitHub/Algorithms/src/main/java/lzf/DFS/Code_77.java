package lzf.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(new Code_77().combine(n,k));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return res;
    }
    private void backTracking (int n,int k,int startIndex) {
        //终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n-(k-path.size()) + 1; i++) {
            path.add(i);
            backTracking(n,k,i+1);
            path.removeLast(); //使用ArrayList<>()的就是 path.remove(path.size()-1)
        }
    }
}
