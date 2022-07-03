package lzf.Hw;

import java.util.*;

/**
 * 最小交换次数
 * https://blog.csdn.net/liqingbing12/article/details/104196681
 */
public class Code_25_8 {
    public static void main(String[] args) {
        int[] nums = {1,4,6,3,7,9,5,2};
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            list.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
        }
        Collections.sort(list, (o1, o2) -> o1-o2);
        System.out.println(Arrays.toString(nums));
        System.out.println(list);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int li = list.get(i);
            if (num == li){
                continue;
            }else {
                int index = 0;
                for (Map.Entry<Integer, Integer> m:map.entrySet()) {
                    if (m.getValue()==li){
                        index = m.getKey();
                    }
                }
                int temp = num;
                nums[i] = nums[index];
                map.put(i,nums[index]);
                nums[index] = temp;
                map.put(index,temp);
                count++;
            }
        }
        System.out.println(count);
    }
}
