package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_450 {
    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(7,null,null);
        TreeNode node5 = new TreeNode(4,null,null);
        TreeNode node4 = new TreeNode(2,null,null);
        TreeNode node3 = new TreeNode(6,null,node6);
        TreeNode node2 = new TreeNode(3,node4,node5);
        TreeNode node1 = new TreeNode(5,node2,node3);
        int key = 3;
        System.out.println(new Code_450().deleteNode(node1,key));
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            TreeNode t = root.left;
            while(t.right != null) {
                t = t.right;
            }
            t.right = root.right;
            return root.left;
        }else if (root.val < key) {
            root.right = deleteNode(root.right,key);
        }else {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
    //
    /*public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }*/

}
