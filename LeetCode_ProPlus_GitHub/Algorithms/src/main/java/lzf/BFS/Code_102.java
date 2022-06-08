package lzf.BFS;

import lzf.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_102 {
    public static void main(String[] args) {
        TreeNode nodeRight1 = new TreeNode(7,null,null);
        TreeNode nodeLeft1 = new TreeNode(15,null,null);
        TreeNode nodeRight = new TreeNode(20,nodeLeft1,nodeRight1);
        TreeNode nodeLeft = new TreeNode(9,null,null);
        TreeNode nodeRoot = new TreeNode(3,nodeLeft,nodeRight);
        System.out.println(new Code_102().levelOrder(nodeRoot));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 存放结果集
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 将根节点加入队列中
        queue.add(root);
        // 开始遍历队列，直到队列为空
        while (!queue.isEmpty()) {
            // 用于存放当前这一层的所有节点值
            List<Integer> curLevel = new ArrayList<>();
            // 当前遍历这一层节点数量
            int curLevelNum = queue.size();
            // 知道当前遍历这一层节点的数量
            // 就知道要队列中元素要出队几次了
            for (int i = 0; i < curLevelNum; i++) {
                // 队列中元素出队
                TreeNode curNode = queue.removeFirst();
                // 将节点值存入
                curLevel.add(curNode.val);
                // 如果当前节点的左节点不为空
                // 则加入队列，等待下一轮遍历
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                // 如果当前节点的右节点不为空
                // 则加入队列，等待下一轮遍历
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }

    // 层序遍历，广度优先搜索模板代码
    /*public void levelOrder(TreeNode root){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right)
            }
        }
    }*/
}
