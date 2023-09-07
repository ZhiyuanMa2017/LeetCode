class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        left--;
        right--;
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode cur = head;
        ListNode pre = sentinel;
        int i = 0;
        while (i < left) {
            cur = cur.next;
            pre = pre.next;
            i++;
        }
        ListNode last = cur;
        ListNode rHead = null;
        ListNode next;
        while (i <= right) {
            next = cur.next;
            cur.next = rHead;
            rHead = cur;
            cur = next;
            i++;
        }
        last.next = cur;
        pre.next = rHead;
        return sentinel.next;
    }
}
