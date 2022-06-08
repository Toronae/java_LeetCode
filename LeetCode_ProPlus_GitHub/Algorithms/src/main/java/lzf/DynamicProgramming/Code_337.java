package lzf.DynamicProgramming;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lzf.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Code_337 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(1,null,null);
        TreeNode node4 = new TreeNode(3,null,null);
        TreeNode node3 = new TreeNode(3,null,node5);
        TreeNode node2 = new TreeNode(2,null,node4);
        TreeNode node1 = new TreeNode(3,node2,node3);
        System.out.println(new Code_337().rob(node1));
    }

    Map<TreeNode,Integer> map1 = new HashMap<>();
    Map<TreeNode,Integer> map2 = new HashMap<>();
    public int rob(TreeNode root) {
        backTracking(root);
        return Math.max(map1.getOrDefault(root,0), map2.getOrDefault(root,0));
    }

    private void backTracking(TreeNode root) {
        if (root == null) {
            return;
        }
        backTracking(root.left);
        backTracking(root.right);
        map1.put(root, root.val + map2.getOrDefault(root.left, 0) + map2.getOrDefault(root.right, 0));
        map2.put(root, Math.max(map1.getOrDefault(root.left, 0), map2.getOrDefault(root.left, 0)) + Math.max(map1.getOrDefault(root.right, 0), map2.getOrDefault(root.right, 0)));
    }
}
