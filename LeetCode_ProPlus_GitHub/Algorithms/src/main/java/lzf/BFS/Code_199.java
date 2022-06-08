package lzf.BFS;

import lzf.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_199 {
    public static void main(String[] args) {
        TreeNode nodeRight1 = new TreeNode(4,null,null);
        TreeNode nodeLeft1 = new TreeNode(5,null,null);
        TreeNode nodeRight = new TreeNode(3,null,nodeRight1);
        TreeNode nodeLeft = new TreeNode(2,null,nodeLeft1);
        TreeNode nodeRoot = new TreeNode(1,nodeLeft,nodeRight);
        System.out.println(new Code_199().rightSideView(nodeRoot));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> Queue = new LinkedList<>();
        Queue.offer(root);
        while (!Queue.isEmpty()){
            int len = Queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = Queue.poll();
                if (node.left != null) {
                    Queue.offer(node.left);
                }
                if (node.right != null) {
                    Queue.offer(node.right);
                }
                if (i == len-1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
