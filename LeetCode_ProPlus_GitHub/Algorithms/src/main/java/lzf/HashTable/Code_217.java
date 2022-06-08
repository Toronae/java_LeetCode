package lzf.HashTable;

import java.util.HashSet;

public class Code_217 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Code_217().containsDuplicate(nums));
    }

    //hashset 方法
    public boolean containsDuplicate(int[] nums) {
        if (nums ==null ||nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() == nums.length? false : true;
    }

    // hashmap 方法
    /*public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
//        Hashtable<Integer, Integer> map = new Hashtable<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (int k: map.keySet()) {
            if (map.get(k) >1) {
                return true;
            }
        }
        return false;
    }*/
}
