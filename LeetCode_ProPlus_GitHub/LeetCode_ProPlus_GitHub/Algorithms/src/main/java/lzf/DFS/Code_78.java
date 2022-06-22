package lzf.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Code_78().subsets(nums));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        backTracking(nums,0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        // 「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.removeLast();
        }
    }
}
