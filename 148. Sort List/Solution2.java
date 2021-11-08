class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        for (int step = 1; step < n; step *= 2) {
            ListNode prevTail = sentinel;
            ListNode cur = prevTail.next;
            while (cur != null) {
                ListNode first = cur;
                ListNode second = getNextStart(cur, step);
                cur = getNextStart(second, step);
                prevTail = merge(first, second, prevTail);
            }
        }
        return sentinel.next;
    }

    private ListNode getNextStart(ListNode first, int step) {
        if (first == null) {
            return null;
        }
        ListNode prevSecond = null;
        while (first != null) {
            prevSecond = first;
            step--;
            first = first.next;
            if (step == 0) {
                break;
            }
        }
        prevSecond.next = null;
        return first;
    }

    private ListNode merge(ListNode first, ListNode second, ListNode prevTail) {
        ListNode cur = prevTail;
        while (first != null && second != null) {
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if (first != null) {
            cur.next = first;
        }
        if (second != null) {
            cur.next = second;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }


    public class ListNode {
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
