package lzf.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_77 {
    public static void main(String[] args) {
        int n =4,k=2;
        System.out.println(new Code_77().combine(n,k));
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        BackTracking(n,k,1);
        return result;
    }

    private void BackTracking(int n, int k, int startIndex) {
        if (paths.size() == k) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i <= n-(k-paths.size())+1; i++) {
            paths.add(i);
            BackTracking(n,k,i+1);
            paths.removeLast();
        }
    }
}
