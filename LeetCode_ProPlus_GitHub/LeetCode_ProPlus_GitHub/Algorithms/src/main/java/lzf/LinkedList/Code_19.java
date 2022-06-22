package lzf.LinkedList;

import lzf.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Code_19 {
    public static void main(String[] args) {
        int n = 2;
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println(new Code_19().removeNthFromEnd(node1,n));
    }

    // 栈：我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，
    // 我们弹出栈的第 n 个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }



    // 快慢指针

    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index1 = head;
        ListNode index2 = head;
        for (int i = 0; i < n; i++) {
            index2 = index2.next;
        }
        if (index2 == null) {
            return head.next;
        }
        while (index2.next != null) {
            index2 = index2.next;
            index1 = index1.next;
        }
        index1.next = index1.next.next;
        return head;
    }*/
}
