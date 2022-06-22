package lzf.BFS;

import lzf.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code_107 {
    public static void main(String[] args) {
        TreeNode nodeRight1 = new TreeNode(7,null,null);
        TreeNode nodeLeft1 = new TreeNode(15,null,null);
        TreeNode nodeRight = new TreeNode(20,nodeLeft1,nodeRight1);
        TreeNode nodeLeft = new TreeNode(9,null,null);
        TreeNode nodeRoot = new TreeNode(3,nodeLeft,nodeRight);
        System.out.println(new Code_107().levelOrderBottom(nodeRoot));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int curLevelNum = queue.size();
            for (int i = 0; i < curLevelNum; i++) {
                TreeNode curNode = queue.removeFirst();
                curLevel.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                // 如果当前节点的右节点不为空
                // 则加入队列，等待下一轮遍历
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.addFirst(curLevel);
        }
        return res;
    }
}
