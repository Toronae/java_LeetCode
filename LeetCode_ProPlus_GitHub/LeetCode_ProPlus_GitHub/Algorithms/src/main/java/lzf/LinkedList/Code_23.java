package lzf.LinkedList;

import lzf.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class Code_23 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list2.next = new ListNode(6);
        ListNode[] lists = {list1,list2,list3};
        System.out.println(new Code_23().mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode mergeNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            mergeNode = merge(mergeNode,lists[i]);
            }
        return mergeNode;
        }

    private ListNode merge(ListNode a,ListNode b){
        if (a == null){
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val < b.val) {
            a.next = merge(a.next,b);
            return a;
        }else {
            b.next = merge(a,b.next);
            return b;
        }
    }

    /*public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }*/


    /*public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val,o2.val));
        for (ListNode l:lists) {
            if (l != null) {
                pq.add(l);
            }
        }
        while (!pq.isEmpty()) {
            ListNode curr = (ListNode) pq.poll();
            prev.next = curr;
            prev = prev.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return dummyHead.next;
    }*/
}
