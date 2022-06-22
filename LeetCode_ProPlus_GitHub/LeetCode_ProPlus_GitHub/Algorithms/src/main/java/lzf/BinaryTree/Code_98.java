package lzf.BinaryTree;

import lzf.TreeNode;

import java.util.Stack;

public class Code_98 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1,null,null);
        TreeNode right = new TreeNode(3,null,null);
        TreeNode root = new TreeNode(2,left,right);
        System.out.println(new Code_98().isValidBST(root));
    }

    // 递归

    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }

    // 迭代
    /*public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;// 左
            }
            // 中，处理
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;

            root = pop.right;// 右
        }
        return true;
    }*/
}
