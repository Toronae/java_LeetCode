package lzf.DFS;

import lzf.TreeNode;

public class Code_938 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(8,null,null);
        TreeNode node8 = new TreeNode(0,null,null);
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(6,null,null);
        TreeNode node4 = new TreeNode(2,node7,node6);
        TreeNode node3 = new TreeNode(1,node8,node9);
        TreeNode node2 = new TreeNode(5,node5,node4);
        TreeNode node1 = new TreeNode(3,node2,node3);
        int row = 4, high = 2;
        System.out.println(new Code_938().rangeSumBST(node1,row,high));
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        //DFS
        //利用二叉搜索树的性质，进行深度优先遍历

        if (root == null) {
            return 0;
        }

        //如果节点值在目标范围内（不包含），则计算左子树范围和+右子树范围和+当前值
        if (root.val > low && root.val < high) {
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
        }
        //如果节点值等于低位值，计算右子树范围和+当前值
        else if (root.val == low) {
            return rangeSumBST(root.right, low, high) + root.val;
        }
        //如果节点值等于高位值，计算左子树范围和+当前值
        else if (root.val == high) {
            return rangeSumBST(root.left, low, high) + root.val;
        }
        //如果节点值小于低位值，计算右子树范围和
        else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        //如果节点值大于高位值，计算左子树范围和
        else {
            return rangeSumBST(root.left, low, high);
        }
    }
}
