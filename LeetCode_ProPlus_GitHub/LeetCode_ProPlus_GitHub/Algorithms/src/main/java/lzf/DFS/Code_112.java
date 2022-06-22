package lzf.DFS;

import lzf.TreeNode;

public class Code_112 {
    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(1,null,null);
        TreeNode node9 = new TreeNode(7,null,null);
        TreeNode node8 = new TreeNode(2,null,null);
        TreeNode node7 = new TreeNode(13,null,null);
        TreeNode node5 = new TreeNode(4,null,node10);
        TreeNode node4 = new TreeNode(11,node9,node8);
        TreeNode node3 = new TreeNode(8,node7,node5);
        TreeNode node2 = new TreeNode(4,node4,null);
        TreeNode node1 = new TreeNode(5,node2,node3);
        int targetSum = 22;
        System.out.println(new Code_112().hasPathSum(node1,targetSum));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
