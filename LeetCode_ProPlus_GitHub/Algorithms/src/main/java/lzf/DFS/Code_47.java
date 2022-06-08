package lzf.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code_47 {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new Code_47().permuteUnique(nums));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTracking(nums,used);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true,说明同一树枝nums[i-1]使用过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i >0 && nums[i] == nums[i-1] && !used[i - 1]) {
                continue;
            }
            // 如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                //标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                used[i] = true;
                path.add(nums[i]);
                backTracking(nums, used);
                // 回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                path.removeLast();
                // 回溯
                used[i] = false;
            }
        }

    }
}
