package lzf.LinkedList;

import lzf.ListNode;

public class Code_876 {
    public static void main(String[] args) {
        ListNode list5 = new ListNode(5,null);
        ListNode list4 = new ListNode(4,list5);
        ListNode list3 = new ListNode(3,list4);
        ListNode list2 = new ListNode(2,list3);
        ListNode list1 = new ListNode(1,list2);
        System.out.println(new Code_876().middleNode(list1));
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
