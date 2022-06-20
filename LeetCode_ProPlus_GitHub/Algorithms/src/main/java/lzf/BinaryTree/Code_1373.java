package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_1373 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(4,null,null);
        TreeNode node6 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(4,null,null);
        TreeNode node4 = new TreeNode(2,node6,null);
        TreeNode node3 = new TreeNode(3,node4,node7);
        TreeNode node2 = new TreeNode(2,node5,null);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(new Code_1373().maxSumBST(node1));
    }
    int ans = 0;

    public int maxSumBST(TreeNode root) {
        postorder(root);
        return ans;
    }

    /**
     * 返回 null 则 root 不是 BST
     * 返回 {} 则 root 是空 BST
     * 返回 {min,max,sum} 则 root 是非空BST
     */
    int[] postorder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        int[] L = postorder(root.left);
        int[] R = postorder(root.right);
        // 左右树必须都是BST才行
        if (L == null || R == null) {
            return null;
        }
        int min = root.val, max = root.val, sum = root.val;
        if (L.length == 3) {
            // 当前val必须大于左树的最大值
            if (root.val <= L[1]) {
                return null;
            }
            // 最小值更新为左树最小值
            min = L[0];
            sum += L[2];
        }
        if (R.length == 3) {
            // 当前val必须小于右树的最小值
            if (root.val >= R[0]) {
                return null;
            }
            // 最大值更新为右树最大值
            max = R[1];
            sum += R[2];
        }
        ans = Math.max(ans, sum);
        return new int[]{min, max, sum};
    }
}
