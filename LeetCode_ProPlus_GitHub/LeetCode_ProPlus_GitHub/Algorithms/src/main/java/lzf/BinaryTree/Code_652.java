package lzf.BinaryTree;

import lzf.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Code_652 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(4,null,null);
        TreeNode node6 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(4,null,null);
        TreeNode node4 = new TreeNode(2,node6,null);
        TreeNode node3 = new TreeNode(3,node4,node7);
        TreeNode node2 = new TreeNode(2,node5,null);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(new Code_652().findDuplicateSubtrees(node1));
    }

    // 2.1 定义一个哈希表来存储每个节点的子树的序列化结果

    private Map<String, Integer> subTreeMap = new HashMap<>();
    private LinkedList<TreeNode> res = new LinkedList<>();


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //以自己为根的子树长啥样，二叉树序列化
        traverse(root);
        return res;
    }

    //拼接字符串的方式把二叉树序列化

    public String traverse(TreeNode root){
        // 对于空节点，可以用一个特殊字符表示
        if(root == null){
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = traverse(root.left);
        String right = traverse(root.right);
        /* 后序遍历代码位置 */
        // 1.以自己为根的子树长啥样。左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left + "," + right + "," + root.val;
        // 2.用一个哈希表（因为题目不要求重复出现结果），来存储每个节点的子树的序列化结果以及其出现的次数
        // 2.2.哈希表中不同子树出现的次数
        //哈希表中不同子树出现的次数
        int frequency = subTreeMap.getOrDefault(subTree, 0);
        // 2.3.多次重复也只会被加入结果集一次
        if(frequency == 1){
            res.add(root);
        }
        //次数+1
        subTreeMap.put(subTree, frequency + 1);
        return subTree;
    }
}
