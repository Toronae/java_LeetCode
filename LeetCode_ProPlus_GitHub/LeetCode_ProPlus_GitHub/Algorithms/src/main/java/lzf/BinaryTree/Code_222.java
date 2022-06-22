package lzf.BinaryTree;

import lzf.TreeNode;

import java.util.*;

public class Code_222 {

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,node6,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(new Code_222().countNodes(node1));
    }

    // 递归
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left+right+1;
    }

    // 广度遍历，用队列实现
    /*public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            res++;
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
        return res;
    }*/

    // 深度遍历，用栈实现

    /*public int countNodes(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        int res = 0;
        while (!stack.isEmpty()){
            TreeNode poll = stack.pop();
            res++;
            if (poll.left != null) stack.push(poll.left);
            if (poll.right != null) stack.push(poll.right);
        }
        return res;
    }*/




    // 前序遍历
    /*public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> res = new ArrayList<>();
        BackTracking(root,res);
        return res.size();
    }

    private void BackTracking(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        BackTracking(root.left,res);
        BackTracking(root.right,res);
    }*/
}
