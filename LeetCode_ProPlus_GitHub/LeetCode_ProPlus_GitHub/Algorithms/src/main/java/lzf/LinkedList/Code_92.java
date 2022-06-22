package lzf.LinkedList;

import lzf.ListNode;

public class Code_92 {
    public static void main(String[] args) {
        ListNode list5 = new ListNode(5,null);
        ListNode list4 = new ListNode(4,list5);
        ListNode list3 = new ListNode(3,list4);
        ListNode list2 = new ListNode(2,list3);
        ListNode list1 = new ListNode(1,list2);
        int left = 2, right = 4;
        System.out.println(new Code_92().reverseBetween(list1,left,right));
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right-left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
