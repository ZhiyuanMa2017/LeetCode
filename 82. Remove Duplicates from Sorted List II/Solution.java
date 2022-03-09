class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(-200);
        sentinel.next = head;
        ListNode curr = head;
        ListNode prev = sentinel;
        ListNode prevprev = new ListNode(-300);
        prevprev.next = sentinel;
        while (curr != null) {
            if (prev.val != curr.val) {
                prevprev = prevprev.next;
                prev = prev.next;
                curr = curr.next;
            } else {
                while (prev.val == curr.val) {
                    curr = curr.next;
                    if (curr == null) {
                        break;
                    }
                }
                prevprev.next = curr;
                if (curr != null) {
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return sentinel.next;
    }
}
