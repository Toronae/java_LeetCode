package lzf.LinkedList;

import lzf.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Code_234 {
    public static void main(String[] args) {
        ListNode list4 = new ListNode(1,null);
        ListNode list3 = new ListNode(2,list4);
        ListNode list2 = new ListNode(2,list3);
        ListNode list1 = new ListNode(1,list2);
        System.out.println(new Code_234().isPalindrome(list1));
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> val = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            val.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = val.size()-1;
        while (left < right) {
            if (!val.get(left).equals(val.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
