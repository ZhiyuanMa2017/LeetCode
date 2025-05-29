class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        int mm = m;
        int nn = n;
        ListNode cur = head;
        while (mm > 0 && cur != null) {
            pre = cur;
            cur = cur.next;
            mm--;
        }
        pre.next = null;
        while (nn > 0 && cur != null) {
            cur = cur.next;
            nn--;
        }
        pre.next = deleteNodes(cur, m, n);
        return head;
    }
}
