package lzf.DivideConquer;

public class Code_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,-4};
        System.out.println(new Code_53().maxSubArray(nums));
    }

    // 分治法
    public int getMax(int[] nums, int low, int high) {
        // 如果子数组只有一个元素，这个元素就是子树组的最大和。
        if (low == high) {
            return nums[low];
        }
        int mid = low + (high - low) / 2;
        // 求左数组的最大和
        int leftMax = getMax(nums, low, mid);
        // 求右数组的最大和
        int rightMax = getMax(nums, mid + 1, high);
        // 求跨越情况的最大和
        int crossMax = getCrossMax(nums, low, mid, high);
        // 返回最大
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
    // 求跨越情况的最大和
    public int getCrossMax(int[] nums, int low, int mid, int high) {
        // 从中间向左走，一直累加，每次累计后都取最大值，最后得到的就是从中间向左累加可得到最大和
        int leftSum = nums[mid];
        int leftMax = nums[mid];
        for (int i = mid - 1; i >= low; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        // 从中间向右走，一直累加，每次累计后都取最大值，最后得到的就是从中间向右累加可得到最大和
        int rightSum = nums[mid+1];
        int rightMax = nums[mid+1];
        for (int i = mid + 2; i <= high; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        // 向左累加的最大和加上向右累加的最大和，就是跨越情况下的最大和
        return leftMax + rightMax;
    }

    public int maxSubArray(int[] nums) {
        return getMax(nums, 0 , nums.length - 1);
    }
    // 动态规划
    /*public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }*/


    /*public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum >0) {
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            res = Math.max(res,sum);
        }

        *//*for (int num:nums) {
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(res,sum);
        }*//*

        return res;
    }*/

    // 暴力破解

    /*public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                res = Math.max(count, res);
            }
        }
        return res;
    }*/
}
