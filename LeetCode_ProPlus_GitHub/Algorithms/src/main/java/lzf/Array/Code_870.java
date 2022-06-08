package lzf.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static com.sun.javafx.scene.traversal.Hueristic2D.findMin;

public class Code_870 {
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {1,10,4,11};
        System.out.println(Arrays.toString(new Code_870().advantageCount(nums1, nums2)));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {

        int length = nums1.length;
        int[] res = new int[length];

        Arrays.sort(nums1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < length; i++) {
            pq.add(new int[]{nums2[i], i});
        }

        int left = 0;
        int right = length - 1;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int index = cur[1];
            int val = cur[0];
            if (nums1[right] > val) {
                res[index] = nums1[right--];
            } else {
                res[index] = nums1[left++];
            }
        }
        return res;
    }

    /*public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums1) {
            list.add(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums1[i] = findMin(list,nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == -1) {
                nums1[i] = list.get(0);
                list.remove(0);
            }
        }
       return nums1;
    }
    private int findMin(List<Integer> list, int x) {
        for (Integer integer : list) {
            if (integer > x){
                list.remove(integer);
                return integer;
            }
        }
        return -1;
    }*/



}
