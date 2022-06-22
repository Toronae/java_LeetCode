package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_104 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(7,null,null);
        TreeNode node4 = new TreeNode(15,null,null);
        TreeNode node3 = new TreeNode(20,node4,node5);
        TreeNode node2 = new TreeNode(9,null,null);
        TreeNode node1 = new TreeNode(3,node2,node3);
        System.out.println(new Code_104().maxDepth(node1));
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) +1;
    }
}
