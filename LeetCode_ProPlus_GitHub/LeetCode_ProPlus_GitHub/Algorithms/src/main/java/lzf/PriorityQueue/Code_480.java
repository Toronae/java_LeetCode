package lzf.PriorityQueue;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Code_480 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new Code_480().medianSlidingWindow(nums, k)));
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        /*
        滑窗+对顶堆:
        我们创建两个堆left和right,其中left是大顶堆存储小的一半元素,right为小顶堆存储大的一半元素
        假定right存储的元素数目总是>=left存储的元素数目
        1.当窗口元素总数为奇数时:中位数为排序k/2的数字,此时直接right堆顶就是答案
        2.当窗口元素总数为偶数时:中位数为排序k/2与(k-1)/2的均值,此时将left堆顶与right堆顶取均值即可\
        还要注意的是:窗口滑动过程中我们加入与删除元素后记得调整堆使得堆平衡
         */
        int len = nums.length;
        int cnt = len - k + 1;  // 滑窗个数
        double[] res = new double[cnt];
        // Integer.compare(b, a)逻辑为:(x < y) ? -1 : ((x == y) ? 0 : 1) 只比较不会加减
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // 大顶堆(注意不要b-a防止溢出)
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> Integer.compare(a, b)); // 小顶堆
        // 初始化堆:[0,k-1] 使得right>=left
        for (int i = 0; i < k; i++) {
            right.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            left.add(right.poll()); // 弹出最小的数字给left
        }
        // 首个中位数加入res
        res[0] = getMid(left, right);
        // 这里的i代表即将加入窗口的右端元素
        for (int i = k; i < len; i++) {
            int a = nums[i], b = nums[i - k];   // a为即将加入窗口的元素,b为即将退出窗口的元素
            if (a >= right.peek()) {
                right.add(a);
            } else {
                left.add(a);
            }
            if (b >= right.peek()) {
                right.remove(b);
            } else {
                left.remove(b);
            }
            // 调整堆
            adjust(left, right);
            // 该窗口中位数加入结果
            res[i - k + 1] = getMid(left, right);
        }
        return res;
    }

    // 调整堆使得堆平衡
    private void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        while (left.size() > right.size()) {
            right.add(left.poll());  // 左边比右边多,左边必定不符合条件,往右边搬
        }
        while (right.size() > left.size() + 1) {
            left.add(right.poll());  // 右边比左边多1以上,右边必定多了,往左边搬
        }
    }

    // 根据left与right两个堆返回中位数
    private double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() == right.size()) {
            return left.peek() / 2.0 + right.peek() / 2.0;  // 范围不知道防止溢出
        } else {
            return (double) right.peek();
        }
    }
    /*public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int cnt = n - k + 1;
        double[] ans = new double[cnt];
        // 如果是奇数滑动窗口，让 right 的数量比 left 多一个
        PriorityQueue<Integer> left  = new PriorityQueue<>((a, b)->Integer.compare(b,a)); // 滑动窗口的左半部分
        PriorityQueue<Integer> right = new PriorityQueue<>((a,b)->Integer.compare(a,b)); // 滑动窗口的右半部分
        for (int i = 0; i < k; i++) {
            right.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            left.add(right.poll());
        }
        ans[0] = getMid(left, right);
        for (int i = k; i < n; i++) {
            // 人为确保了 right 会比 left 多，因此，删除和添加都与 right 比较（left 可能为空）
            int add = nums[i], del = nums[i - k];
            if (add >= right.peek()) {
                right.add(add);
            } else {
                left.add(add);
            }
            if (del >= right.peek()) {
                right.remove(del);
            } else {
                left.remove(del);
            }
            adjust(left, right);
            ans[i - k + 1] = getMid(left, right);
        }
        return ans;
    }
    void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        while (left.size() > right.size()) {
            right.add(left.poll());
        }
        while (right.size() - left.size() > 1) {
            left.add(right.poll());
        }
    }
    double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() == right.size()) {
            return (left.peek() / 2.0) + (right.peek() / 2.0);
        } else {
            return right.peek() * 1.0;
        }
    }*/

    // 暴力破解
    /*public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int cnt = n - k + 1;
        double[] ans = new double[cnt];
        int[] t = new int[k];
        for (int l = 0, r = l + k - 1; r < n; l++, r++) {
            for (int i = l; i <= r; i++) {
                t[i - l] = nums[i];
            }
            Arrays.sort(t);
            ans[l] = (t[k / 2] / 2.0) + (t[(k - 1) / 2] / 2.0);
        }
        return ans;
    }*/

    /*public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int[] temp = new int[k];
        for (int i = 0; i < n - k + 1; i ++) {
            for (int j = 0; j < k; j ++) {
                temp[j] = nums[i + j];
            }
            Arrays.sort(temp);
            if (k % 2 == 0) {
                ans[i] = (double)(temp[k / 2 - 1]) / 2 + (double)(temp[k / 2]) / 2;
            }
            else {
                ans[i] = temp[k / 2];
            }
        }
        return ans;
    }*/

}
