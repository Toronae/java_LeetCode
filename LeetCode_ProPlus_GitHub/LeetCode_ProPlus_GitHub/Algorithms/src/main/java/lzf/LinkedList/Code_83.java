package lzf.LinkedList;

import lzf.ListNode;

public class Code_83 {
    public static void main(String[] args) {
        ListNode list3 = new ListNode(2,null);
        ListNode list2 = new ListNode(1,list3);
        ListNode list1 = new ListNode(1,list2);
        System.out.println(new Code_83().deleteDuplicates(list1));
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        while(current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
}
