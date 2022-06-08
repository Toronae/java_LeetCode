package lzf.BinaryTree;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lzf.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Code_116 {
    public static void main(String[] args) {
        Node node7 = new Node(7,null,null,null);
        Node node6 = new Node(6,null,null,null);
        Node node5 = new Node(5,null,null,null);
        Node node4 = new Node(4,null,null,null);
        Node node3 = new Node(3,node6,node7,null);
        Node node2 = new Node(2,node4,node5,null);
        Node node1 = new Node(1,node2,node3,null);
        System.out.println(new Code_116().connect(node1));
    }


    public Node connect(Node root) {
        backTracking(root);
        return root;

    }

    private void backTracking(Node cur) {
        if (cur == null) {
            return;
        }
        if (cur.left != null) {
            cur.left.next = cur.right;
        }
        if (cur.right != null) {
            if (cur.next != null){
                cur.right.next = cur.next.left;
            }else {
                cur.right.next = null;
            }
        }
        backTracking(cur.left);
        backTracking(cur.right);
    }

    // 层序遍历
    /*public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回根节点
        return root;
    }*/


    // 迭代法

    /*public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> que = new LinkedList<Node>();
        que.offer(root);
        Node nodePre = null;
        Node node = null;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i=0; i<size; i++) { // 开始每一层的遍历
                if (i == 0) {
                    nodePre = que.peek(); // 记录一层的头结点
                    que.poll();
                    node = nodePre;
                } else {
                    node = que.peek();
                    que.poll();
                    nodePre.next = node; // 本层前一个节点next指向本节点
                    nodePre = nodePre.next;
                }
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            nodePre.next = null; // 本层最后一个节点指向null
        }
        return root;
    }*/

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
