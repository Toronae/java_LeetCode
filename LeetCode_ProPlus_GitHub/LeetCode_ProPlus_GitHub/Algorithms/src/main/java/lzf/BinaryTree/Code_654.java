package lzf.BinaryTree;

import lzf.TreeNode;

/**
 * 根据题目示例，只能先遍历右子树， 然后中间 然后左子树。
 * 中间用一个全局变量存储累积和。
 * sum 先记录总和，然后修改当前root的val。
 */
public class Code_654 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        System.out.println(new Code_654().constructMaximumBinaryTree(nums));
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r){
            return null;
        }
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i]){
                max_i = i;
            }
        }
        return max_i;
    }

}
