package lzf.DFS;

import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Code_46().permute(nums));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        backTracking(nums,path);
        return res;
    }

    private void backTracking(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums,path);
            path.removeLast();
        }
    }
}
