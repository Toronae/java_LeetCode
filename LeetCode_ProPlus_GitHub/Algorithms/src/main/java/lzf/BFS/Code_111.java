package lzf.BFS;

import lzf.TreeNode;

import java.util.LinkedList;

public class Code_111 {
    public static void main(String[] args) {
        TreeNode nodeRight1 = new TreeNode(7,null,null);
        TreeNode nodeLeft1 = new TreeNode(15,null,null);
        TreeNode nodeRight = new TreeNode(20,nodeLeft1,nodeRight1);
        TreeNode nodeLeft = new TreeNode(9,null,null);
        TreeNode nodeRoot = new TreeNode(3,nodeLeft,nodeRight);
        System.out.println(new Code_111().minDepth(nodeRoot));
    }
    public int minDepth(TreeNode root) {
        if (root == null ){
            return 0;
        }
        int depth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode curNode = queue.removeFirst();
                if (curNode.right == null && curNode.left == null) {
                    return depth;
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
