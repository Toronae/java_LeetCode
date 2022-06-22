package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_538 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(new Code_538().convertBST(node1));
    }

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
        return sum;
    }

    /*int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }*/
}
