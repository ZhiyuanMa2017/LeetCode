/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ListNode sentinel  = new ListNode();

        while (curr != null) {
            ListNode prev  = sentinel;
            while (prev.next != null) {
                if (curr.val < prev.next.val) {
                    break;
                }
                prev = prev.next;
            }
            ListNode nextnode = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = nextnode;
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