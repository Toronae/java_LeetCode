package lzf.Two_Pointers;

import lzf.ListNode;

import java.util.HashSet;

public class Code_141 {
    public static void main(String[] args) {

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
    // ListNode slow = head, fast = head;
    // do {
    //     if(fast == null || fast.next == null) {
    //         return false;
    //     }
    //     slow = slow.next;
    //     fast = fast.next.next;
    // }while(slow != fast);

    //方法一 常规方法，记录每个访问过的点
    /*public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        while(head != null) {
            if (!visited.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }*/

}
