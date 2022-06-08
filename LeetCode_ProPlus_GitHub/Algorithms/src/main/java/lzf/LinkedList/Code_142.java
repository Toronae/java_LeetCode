package lzf.LinkedList;

import lzf.ListNode;

public class Code_142 {
    public static void main(String[] args) {
        ListNode list2 = null;
        ListNode list4 = new ListNode(-4, list2);
        ListNode list3 = new ListNode(0, list4);
        list2 = new ListNode(2, list3);
        ListNode list1 = new ListNode(3, list2);
        System.out.println(new Code_142().detectCycle(list1));
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast != null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if(slow == fast) {
                fast = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
