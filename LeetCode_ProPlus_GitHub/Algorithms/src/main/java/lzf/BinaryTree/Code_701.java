package lzf.BinaryTree;

import lzf.TreeNode;

public class Code_701 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(4,null,null);
        TreeNode node6 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(4,null,null);
        TreeNode node4 = new TreeNode(2,node6,null);
        TreeNode node3 = new TreeNode(3,node4,node7);
        TreeNode node2 = new TreeNode(2,node5,null);
        TreeNode node1 = new TreeNode(1,node2,node3);
        int val = 5;
        System.out.println(new Code_701().insertIntoBST(node1,val));
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        //用于遍历
        TreeNode node = root;
        while(node != null){
            if (val > node.val){
                //当插入值大于当前节点，判断当前节点右边是否有空位可插入
                if (node.right == null){
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            }else{
                //当插入值小于当前节点，判断当前节点左边是否有空位可插入
                if (node.left == null){
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            }
        }
        return root;
    }
}
