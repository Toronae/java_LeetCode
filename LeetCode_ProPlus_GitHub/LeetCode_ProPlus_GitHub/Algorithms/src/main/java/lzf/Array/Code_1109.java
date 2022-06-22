package lzf.Array;

import java.util.Arrays;

public class Code_1109 {
    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        System.out.println(Arrays.toString(new Code_1109().corpFlightBookings(bookings, n)));
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }


    /*public int[] corpFlightBookings(int[][] bookings, int n) {
        // 类同1094题思想，使用差分思想。
        int[] b = new int[n + 2]; // 由于航班下标从1开始，且右区间是r+1，所以定义长度+2
        for (int i = 0; i < bookings.length; i++) {
            int l = bookings[i][0];
            int r = bookings[i][1];
            int c = bookings[i][2];

            b[l] += c;
            b[r + 1] -= c;
        }
        for (int i = 1; i < b.length; i++) {
            b[i] += b[i - 1];
        }
        return Arrays.copyOfRange(b, 1, b.length - 1);
    }*/

    // 差分数组模板

    public class Difference {

        /**
         * 差分数组
         */
        private final int[] diff;

        /**
         * 初始化差分数组
         * @param nums nums
         */
        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /**
         * 对区间 [i, j] 增加 val（val 可为负数）
         * @param i i
         * @param j j
         * @param val val
         */
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        /**
         * 复原操作
         * @return res
         */
        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

}
