package lzf.BinaryTree;

import lzf.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code_297 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,node4,node5);
        TreeNode node2 = new TreeNode(2,null,null);
        TreeNode node1 = new TreeNode(1,node2,node3);
        String data = "1,2,None,None,3,4,None,None,5,None,None,";
        System.out.println(new Code_297().serialize(node1));
        System.out.println(new Code_297().deserialize(data));
    }
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }

}
