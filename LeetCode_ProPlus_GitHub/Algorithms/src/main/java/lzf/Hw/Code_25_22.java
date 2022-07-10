package lzf.Hw;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.nowcoder.com/discuss/951297?order=1&pos=26&page=2&source_id=discuss_center_0_nctrack&channel=-1&gio_id=-1652605091615
 * 第一题
 */
public class Code_25_22 {
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(new Code_25_22().countSmaller(nums));
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    count++;
                }
            }
            list.add(count);
        }
        return list;
    }
}
