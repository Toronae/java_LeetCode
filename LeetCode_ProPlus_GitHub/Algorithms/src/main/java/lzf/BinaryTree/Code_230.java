package lzf.BinaryTree;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lzf.TreeNode;

import java.util.*;

public class Code_230 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(2,null,null);
        TreeNode node3 = new TreeNode(4,null,null);
        TreeNode node2 = new TreeNode(1,null,node4);
        TreeNode node1 = new TreeNode(3,node2,node3);
        int k = 1;
        System.out.println(new Code_230().kthSmallest(node1,k));
    }

    // 中序遍历
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        midSearch(root,res);
        return res.get(k-1);
    }

    private void midSearch(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        midSearch(root.left,res);
        res.add(root.val);
        midSearch(root.right,res);
    }

    // 迭代中序遍历
    /*public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }*/

    //树的遍历 + 优先队列（堆）

    /*public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode node = d.pollFirst();
            if (q.size() < k) {
                q.add(node.val);
            } else if (q.peek() > node.val) {
                q.poll();
                q.add(node.val);
            }
            if (node.left != null) d.addLast(node.left);
            if (node.right != null) d.addLast(node.right);
        }
        return q.peek();
    }*/


}
