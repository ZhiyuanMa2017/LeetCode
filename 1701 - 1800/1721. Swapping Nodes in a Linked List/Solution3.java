class Solution3 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null;
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            if (last != null) {
                last = last.next;
            }
            k--;
            if (k == 0) {
                first = cur;
                last = head;
            }

            cur = cur.next;
        }
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;
        return head;
    }
}
