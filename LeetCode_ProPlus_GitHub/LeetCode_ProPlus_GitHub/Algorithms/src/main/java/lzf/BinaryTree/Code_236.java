package lzf.BinaryTree;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lzf.TreeNode;

public class Code_236 {
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
        System.out.println(new Code_236().lowestCommonAncestor(node1,node2,node3));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }


    // 递归
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }*/
}
