package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_543 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(new Code_543().diameterOfBinaryTree(node1));
    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
         int left  = maxDepth(root.left);
         int right  = maxDepth(root.right);
         if (max < left + right) {
             max = right +left;
         }
        //节点深度
         return Math.max(right,left) + 1;
    }
}
