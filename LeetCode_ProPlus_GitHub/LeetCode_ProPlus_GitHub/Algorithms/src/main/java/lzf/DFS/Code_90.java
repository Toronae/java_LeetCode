package lzf.DFS;

import java.util.*;

public class Code_90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(new Code_90().subsetsWithDup(nums));
    }
    // 不使用used数组

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums,0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums,i+1);
            path.removeLast();
        }
    }

    // 使用used数组

    /*List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            res.add(path);
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        BackingTracking(nums,0);
        return res;
    }
    private void BackingTracking(int[] nums,int startIndex) {
        res.add(new ArrayList<>(path));
        //终止条件
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            BackingTracking(nums,i+1);
            path.removeLast();
            used[i] = false;
        }
    }*/

    /*public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length ==0) {
            return res;
        }
        Arrays.sort(nums);

        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        res.add(tmp);
        if (nums.length == 1) {
            return res;
        }

        int lastlen = 1;
        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            if (nums[i] != nums[i-1]){
                lastlen = size;
            }
            for (int j = size - lastlen; j < size; j++) {
                List<Integer> inner = new ArrayList<>(res.get(j));
                inner.add(nums[i]);
                res.add(inner);
            }
        }
        return res;
    }*/

    /*public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            res.add(temp);
            for (int j = i+1; j <= nums.length-1 ; j++) {
                List<Integer> inner = new ArrayList<>(res.get(j));
                inner.add(nums[j]);
                res.add(inner);
            }
        }
        HashSet<List<Integer>> distinc = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            distinc.add(res.get(i));
        }
        return res;
    }*/
    /*public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        long l = list.stream().distinct().count();
        System.out.println("No. of distinct elements:"+l);
        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);
    }*/

}
