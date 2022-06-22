package lzf.LinkedList;

import lzf.ListNode;

import java.util.List;

public class Code_206 {
    public static void main(String[] args) {

        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        System.out.println(new Code_206().reverseList(node1));
    }
    public ListNode reverseList(ListNode head) {
        //初始设定
        ListNode pre = null;
        ListNode cur = head;
        //终止条件
        while (cur != null) {
            //暂存
            ListNode temp = cur.next;
            //指向
            cur.next = pre;
            //归位
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
