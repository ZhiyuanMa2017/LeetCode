class Solution {
    int max;

    public ListNode removeNodes(ListNode head) {
        max = 0;
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = helper(head.next);
        if (head.val < max) {
            return next;
        } else {
            max = head.val;
            head.next = next;
            return head;
        }
    }
}
