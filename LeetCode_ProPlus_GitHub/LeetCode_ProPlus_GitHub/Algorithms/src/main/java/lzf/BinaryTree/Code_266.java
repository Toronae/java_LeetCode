package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_266 {
    public static void main(String[] args) {

    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left+right > max){
            max = left+right;
        }
        return Math.max(left,right)+1;
    }
}
