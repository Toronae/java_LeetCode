package lzf.BinaryTree;

import lzf.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code_94 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1,null,null);
        TreeNode right = new TreeNode(3,null,null);
        TreeNode root = new TreeNode(2,left,right);
        System.out.println(new Code_94().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        bfs(root,result);
        return result;
    }

    private void bfs(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        bfs(root.left,result);
        result.add(root.val);
        bfs(root.right,result);
    }
}
