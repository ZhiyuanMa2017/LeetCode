class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int mid = len / 2;

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        while (mid != 0) {
            sentinel = sentinel.next;
            mid--;
        }
        sentinel.next = sentinel.next.next;
        return head;
    }
}
