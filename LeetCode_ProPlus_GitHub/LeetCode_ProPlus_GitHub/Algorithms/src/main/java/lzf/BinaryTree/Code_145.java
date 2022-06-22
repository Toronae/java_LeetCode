package lzf.BinaryTree;

import lzf.TreeNode;

import java.util.*;

public class Code_145 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node3,null);
        TreeNode node1 = new TreeNode(1,null,node2);
        System.out.println(new Code_145().postorderTraversal(node1));
    }

    // 迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                result.add(root.val);
                prev = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    // 递归
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        postorder(root.left,result);
        postorder(root.right,result);
        result.add(root.val);
    }*/
}
