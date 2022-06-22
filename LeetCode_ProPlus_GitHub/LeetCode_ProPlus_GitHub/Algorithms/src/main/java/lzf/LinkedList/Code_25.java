package lzf.LinkedList;

import lzf.ListNode;

public class Code_25 {
    public static void main(String[] args) {
        ListNode list5 = new ListNode(5,null);
        ListNode list4 = new ListNode(4,list5);
        ListNode list3 = new ListNode(3,list4);
        ListNode list2 = new ListNode(2,list3);
        ListNode list1 = new ListNode(1,list2);
        int k = 2;
        System.out.println(new Code_25().reverseKGroup(list1,k));

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
