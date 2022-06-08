package lzf.DFS;

import lzf.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Code_113 {
    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(5,null,null);
        TreeNode node10 = new TreeNode(1,null,null);
        TreeNode node9 = new TreeNode(7,null,null);
        TreeNode node8 = new TreeNode(2,null,null);
        TreeNode node7 = new TreeNode(13,null,null);
        TreeNode node5 = new TreeNode(4,node11,node10);
        TreeNode node4 = new TreeNode(11,node9,node8);
        TreeNode node3 = new TreeNode(8,node7,node5);
        TreeNode node2 = new TreeNode(4,node4,null);
        TreeNode node1 = new TreeNode(5,node2,node3);
        int targetSum = 22;
        System.out.println(new Code_113().pathSum(node1,targetSum));
    }
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null &&targetSum == 0){
            res.add(new LinkedList<>(path));
        }
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        path.pollLast();
    }

}


