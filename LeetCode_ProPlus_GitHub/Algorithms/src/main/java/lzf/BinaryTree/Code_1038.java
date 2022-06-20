package lzf.BinaryTree;

import lzf.TreeNode;

/**
 * 访问每一个节点时，我们希望有一个变量 sum，存了比当前节点值大的所有节点值的和
 * 而，二叉搜索树（BST）的中序遍历，访问的节点值是递增的。
 * 如果先访问右子树，反向的中序遍历，访问的节点值是递减的，之前访问的节点值都比当前的大，累加给 sum 。
 * 对于每一个节点，先递归它的右子树，里面的节点值都比当前节点大，把它们累加给 sum。
 * 再 “处理” 当前节点，sum 累加上当前节点值，更新当前节点值，
 * 再递归它的左子树，sum 保存了比当前节点大的所有节点值的和，累加上当前节点值，更新当前节点值。
 * 注意： 不管访问哪个节点，sum 始终保存了比当前节点值大的所有节点的和
 */
public class Code_1038 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(new Code_1038().bstToGst(node1));
    }
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root != null){
            // 递归右子树的节点和
            bstToGst(root.right);
            sum += root.val;
            // 更新节点的值
            root.val = sum;
            // 递归左子树
            bstToGst(root.left);
        }
        return root;
    }
}
