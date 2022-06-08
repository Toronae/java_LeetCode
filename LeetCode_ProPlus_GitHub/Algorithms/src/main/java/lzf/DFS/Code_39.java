package lzf.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(new Code_39().combinationSum(candidates,target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 先进行排序
        Arrays.sort(candidates);
        backTracking(res,new ArrayList<>(),candidates,target,0,0);
        return res;
    }
    private void backTracking(List<List<Integer>> res,List<Integer> path, int[] candidates,int target,int sum,int startIndex){
        //找到数字和为target的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <candidates.length ; i++) {
            //如果sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] >target) {
                break;
            }
            path.add(candidates[i]);
            backTracking(res, path, candidates, target, sum+candidates[i], i);
            // 回溯，移除路径 path 最后一个元素
            path.remove(path.size()-1);
        }
    }
}
