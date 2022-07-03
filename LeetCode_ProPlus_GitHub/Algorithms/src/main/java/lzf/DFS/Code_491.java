package lzf.DFS;

import java.util.ArrayList;
import java.util.HashSet;
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

    List<List<Integer>> result = new ArrayList<>();
    //暂存结果

    List<Integer> path1 = new ArrayList<>();

    public List<List<Integer>> findSubsequences1(int[] nums) {
        backTrack(nums, 0);
        return result;
    }

    // hashset去重剪枝,

    private void backTrack(int[] nums, int startIndex) {
        if(path.size() > 1){
            result.add(new ArrayList<>(path));  //注意这⾥不要加return，因为要取树上的所有节点
        }
        HashSet<Integer> uset = new HashSet<>(); //录本层元素是否重复使⽤，新的⼀层uset都会重新定义（清空）
        for (int i = startIndex; i < nums.length; i++) {
            //!path.isEmpty()&&nums[i]<path.get(path.size()-1)) : 保证子序列是递增的
            //!uset.add(nums[i]) ：保证在同一层不会重复使用相同数字
            if ((!path.isEmpty()&&nums[i]<path.get(path.size()-1))||uset.contains(nums[i])) {
                continue;
            }
            //hashset做标记，backTrack(nums, i + 1)后不需要remove，used数组做标记，backTrack(nums, i + 1)后要used[i]=false
            uset.add(nums[i]);
            path.add(nums[i]);
            backTrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
