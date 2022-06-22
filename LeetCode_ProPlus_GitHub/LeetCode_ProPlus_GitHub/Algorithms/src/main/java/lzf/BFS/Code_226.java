package lzf.BFS;

import lzf.TreeNode;

import java.util.LinkedList;

public class Code_226 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(9,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(3,null,null);
        TreeNode node4 = new TreeNode(1,null,null);
        TreeNode node3 = new TreeNode(7,node6,node7);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(4,node2,node3);
        System.out.println(new Code_226().invertTree(node1));
    }
    //bfs
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode temp = queue.poll();
            // 交换左右节点
            exchange(temp);

            // 如果当前节点的左子树不为空，则放入队列等待后续处理
            if(temp.left!=null) {
                queue.add(temp.left);
            }
            // 如果当前节点的右子树不为空，则放入队列等待后续处理
            if(temp.right!=null) {
                queue.add(temp.right);
            }
        }
        return root;
    }
    private void exchange(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    // dfs
    /*public TreeNode invertTree(TreeNode root) {
        // 翻转以 root 为根的二叉树，然后返回翻转后的二叉树的根节点

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }*/
}
