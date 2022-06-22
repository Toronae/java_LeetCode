package lzf.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Code_46().permute(nums));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length ==0) {
            return res;
        }
        BackTracking(nums,paths);
        return res;
    }

    private void BackTracking(int[] nums, LinkedList<Integer> paths) {
        if (paths.size() == nums.length) {
            res.add(new ArrayList<>(paths));
        }
        for (int i = 0; i < nums.length;i++){
            if (paths.contains(nums[i])){
                continue;
            }
            paths.add(nums[i]);
            BackTracking(nums, paths);
            paths.removeLast();
        }
    }
}
