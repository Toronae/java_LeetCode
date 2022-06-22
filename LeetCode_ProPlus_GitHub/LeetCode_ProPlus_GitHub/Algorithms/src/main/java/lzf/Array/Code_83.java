package lzf.Array;

import lzf.ListNode;

public class Code_83 {
    public static void main(String[] args) {
        ListNode list4 = new ListNode(3,null);
        ListNode list3 = new ListNode(3,list4);
        ListNode list2 = new ListNode(2,list3);
        ListNode list1 = new ListNode(1,list2);
        ListNode list = new ListNode(1,list1);
        System.out.println(new Code_83().deleteDuplicates(list));
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

    // 递归法
    /*public ListNode deleteDuplicates(ListNode head) {
        if (head ==null || head.next==null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;

        }
        return head;
    }*/
}
