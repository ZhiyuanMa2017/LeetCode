class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = k;
        ListNode nextHead = head;
        while (nextHead != null && count > 0) {
            nextHead = nextHead.next;
            count--;
        }
        if (count > 0) {
            return head;
        }
        ListNode cur = head;
        ListNode sentinel = new ListNode(-1);
        ListNode last = head;
        while (cur != nextHead) {
            ListNode next = cur.next;
            cur.next = sentinel.next;
            sentinel.next = cur;
            cur = next;
        }
        last.next = reverseKGroup(nextHead, k);
        return sentinel.next;
    }
}
