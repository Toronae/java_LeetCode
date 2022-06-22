package lzf.Two_Pointers;

import lzf.ListNode;

public class Code_19 {
    public static void main(String[] args) {
        Code_19 cd = new Code_19();
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println(new Code_19().removeNthFromEnd(node1,2));
        /*ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        System.out.println(new Code_19().removeNthFromEnd(list1,2));*/
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index1 = head;
        ListNode index2 = head;
        for(int i = 0; i < n; i++)  {
            // 使得index1与index2之间间隔n-1个节点
            index2 = index2.next;
        }
        if(index2 == null){
            //说明删除的是头节点
            return head.next;
        }
        while(index2.next != null){
            //将index2移至最后一个节点
            index2 = index2.next;
            index1 = index1.next;
        }
        index1.next = index1.next.next;
        return head;
    }
}
