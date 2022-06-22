package lzf.LinkedList;

import lzf.ListNode;

import java.util.List;

public class Code_203 {
    public static void main(String[] args) {
        int val = 6;
        ListNode node7 = new ListNode(6,null);
        ListNode node6 = new ListNode(5,node7);
        ListNode node5 = new ListNode(4,node6);
        ListNode node4 = new ListNode(3,node5);
        ListNode node3 = new ListNode(6,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println(new Code_203().removeElements(node1,6));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumy = new ListNode(0);
        ListNode cur = dumy;
        cur.next = head;
        while (cur !=null && cur.next !=null) {
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dumy.next;
    }
}
