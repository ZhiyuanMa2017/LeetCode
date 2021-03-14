class Solution2 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null;
        ListNode n2 = null;
        for (ListNode p = head; p != null; p = p.next) {
            n2 = n2 == null ? n2 : n2.next;
            k--;
            if (k == 0) {
                n1 = p;
                n2 = head;
            }
        }
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        return head;
    }
}
