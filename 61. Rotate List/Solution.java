class Solution {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode tail = null;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            if (cur.next == null) {
                tail = cur;
            }
            cur = cur.next;
        }
        k = k % cnt;
        if (k == 0) {
            return head;
        }
        int index = cnt - k;
        int count = 1;
        ListNode curr = head;
        while (count != index) {
            count++;
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        return newHead;
    }

    public static class ListNode {
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
}
