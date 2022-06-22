package lzf.BinaryTree;

import lzf.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Code_144 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node3,null);
        TreeNode node1 = new TreeNode(1,null,node2);
        System.out.println(new Code_144().preorderTraversal(node1));
    }

    // 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            while ( node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return result;
    }

    // 递归
    /*public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> res) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }*/
}
