package lzf.LinkedList;

import lzf.ListNode;

public class Code_141 {
    public static void main(String[] args) {
        ListNode list2 = null;
        ListNode list4 = new ListNode(-4, list2);
        ListNode list3 = new ListNode(0, list4);
        list2 = new ListNode(2, list3);
        ListNode list1 = new ListNode(3, list2);
        System.out.println(new Code_141().hasCycle(list1));
    }
    public boolean hasCycle(ListNode head) {
        // 快慢指针法
        if(head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
