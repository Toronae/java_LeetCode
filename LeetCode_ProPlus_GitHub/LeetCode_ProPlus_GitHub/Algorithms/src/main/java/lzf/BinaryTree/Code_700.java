package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_700 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(3,null,null);
        TreeNode node4 = new TreeNode(1,null,null);
        TreeNode node3 = new TreeNode(7,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(4,node2,node3);
        int val = 2;
        System.out.println(new Code_700().searchBST(node1,val));
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }
}
