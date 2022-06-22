package lzf.DFS;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lzf.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Code_437 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(8,null,null);
        TreeNode node8 = new TreeNode(0,null,null);
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(6,null,null);
        TreeNode node4 = new TreeNode(2,node7,node6);
        TreeNode node3 = new TreeNode(1,node8,node9);
        TreeNode node2 = new TreeNode(5,node5,node4);
        TreeNode node1 = new TreeNode(3,node2,node3);
        int target = 10;
        System.out.println(new Code_437().pathSum(node1,target));
    }

    // BFS + DFS
    int count, num, targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        // BFS遍历所有结点
        while(!q.isEmpty()){
            TreeNode head = q.remove();
            // 考察以当前结点为起始的满足要求的路径数量
            check(head, 0);
            if(head.left != null) {
                q.add(head.left);
            }
            if(head.right != null) {
                q.add(head.right);
            }
        }
        return count;
    }
    private void check(TreeNode node, int sum){
        if(node == null) {
            return;
        }
        sum = sum + node.val;
        if(sum == targetSum) {
            count++; // 一旦满足，立即累计
        }
        check(node.left, sum);
        check(node.right, sum);
    }

    //DFS + DFS(不带返回值
    /*int count, num, targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        this.targetSum = targetSum;
        dfs(root); // DFS遍历所有结点
        return count;
    }
    private void dfs(TreeNode node){
        if(node == null) {
            return;
        }
        check(node, 0); // 考察以当前结点为起始的满足要求的路径数量
        dfs(node.left);
        dfs(node.right);
    }
    private void check(TreeNode node, int sum){
        if(node == null) {
            return;
        }
        sum = sum + node.val;
        if(sum == targetSum) {
            count++; // 一旦满足，立即累计
        }
        check(node.left, sum);
        check(node.right, sum);
    }*/
    // DFS + DFS(带返回值)
    /*public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        int count = nodeSum(root, targetSum);
        return count + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    private int nodeSum(TreeNode node, int targetSum){
        if(node == null) {
            return 0;
        }
        int count = 0, val = node.val;
        if(val == targetSum) {
            count++;
        }
        return count + nodeSum(node.left, targetSum - val) + nodeSum(node.right, targetSum - val);
    }*/

    // 前缀和
    /*int targetSum, count = 0;
    Map<Integer, Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        this.map = new HashMap<>();
        map.put(0, 1); // 表示前缀和为0的节点为空，有一个空。否则若pre_i = targetSum，将错过从root到i这条路径。
        dfs(root, 0);
        return count;
    }
    private void dfs(TreeNode node, int preSum){
        if(node == null) {
            return;
        }
        preSum += node.val;
        count += map.getOrDefault(preSum - targetSum, 0); // #1 累计满足要求的前缀和数量
        map.put(preSum, map.getOrDefault(preSum, 0) + 1); // #2 先累计再put（先#1，再#2）
        dfs(node.left, preSum);
        dfs(node.right, preSum);
        map.put(preSum, map.get(preSum) - 1); // 路径退缩，去掉不再在路径上的当前结点的前缀和。必存在，无需使用getOrDefault。
    }*/
}
