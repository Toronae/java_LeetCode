package lzf.DFS;

import java.util.ArrayList;
import java.util.List;

public class Code_491 {
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        System.out.println(new Code_491().findSubsequences(nums));

    }
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    private void backtracking (int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            //nums[i] < path.get(path.size() - 1)判断是否递增
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
