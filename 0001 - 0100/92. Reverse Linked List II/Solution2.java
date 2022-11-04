class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode cur = head;
        ListNode pre = sentinel;
        while (left > 1) {
            cur = cur.next;
            pre = pre.next;
            left--;
            right--;
        }
        ListNode tail = cur;
        ListNode reverseHead = null;
        ListNode next;
        while (right > 0) {
            next = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
            cur = next;
            right--;
        }
        tail.next = cur;
        pre.next = reverseHead;
        return sentinel.next;
    }
}
