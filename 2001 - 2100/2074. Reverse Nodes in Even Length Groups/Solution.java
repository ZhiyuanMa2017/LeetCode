class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode cur = sentinel;
        ListNode previousEnd = sentinel;
        int num = 1;
        while (cur.next != null) {
            int sum = 0;
            for (int i = 0; i < num; i++) {
                if (cur.next == null) {
                    break;
                }
                sum++;
                cur = cur.next;
            }
            if (sum % 2 == 0) {
                ListNode nextNode = cur.next;
                cur.next = null;
                ListNode[] listNodes = reverse(previousEnd.next);
                previousEnd.next = listNodes[0];
                listNodes[1].next = nextNode;
                cur = listNodes[1];
                previousEnd = listNodes[1];
            } else {
                previousEnd = cur;
            }
            num++;
        }
        return sentinel.next;
    }

    private ListNode[] reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{pre, head};
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
