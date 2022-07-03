package lzf.DFS;

import lzf.TreeNode;

public class Code_112 {
    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(1,null,null);
        TreeNode node9 = new TreeNode(7,null,null);
        TreeNode node8 = new TreeNode(2,null,null);
        TreeNode node7 = new TreeNode(13,null,null);
        TreeNode node5 = new TreeNode(4,null,node10);
        TreeNode node4 = new TreeNode(11,node9,node8);
        TreeNode node3 = new TreeNode(8,node7,node5);
        TreeNode node2 = new TreeNode(4,node4,null);
        TreeNode node1 = new TreeNode(5,node2,node3);
        int targetSum = 22;
        System.out.println(new Code_112().hasPathSum(node1,targetSum));
    }

    //从根节点开始，每当遇到一个节点的时候，从目标值里扣除节点值，一直到叶子节点判断目标值是不是被扣完。

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    //声明一个变量记录已经经过的节点的值之和，每经过一个节点就加上这个节点的值，在叶子节点判断变量值是否为目标值。

    public boolean hasPathSum1(TreeNode root, int sum) {
        return  helper(root,0,sum);
    }
    public boolean helper(TreeNode root,int cur,int sum)
    {
        if(root==null){
            return false;
        }
        cur=cur+root.val;
        if(root.left==null&&root.right==null)
        {
            return cur==sum;
        }else
        {
            return helper(root.left,cur,sum)|| helper(root.right,cur,sum);
        }
    }

}
