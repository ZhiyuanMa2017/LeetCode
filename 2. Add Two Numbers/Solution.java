import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode s1 = l1;
        ListNode s2 = l2;
        int sum = 0;
        ListNode sentinel = new ListNode(0);
        ListNode cur = sentinel;
        while (s1 != null || s2 != null){
            sum /= 10;
            if (s1 != null) {
                sum += s1.val;
                s1 = s1.next;
            }
            if (s2 != null) {
                sum += s2.val;
                s2 = s2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (sum/10 == 1) {
            cur.next = new ListNode(1);
        }
        return sentinel.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
