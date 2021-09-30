class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int count = 0;
        ListNode head = root;
        while (head != null) {
            count++;
            head = head.next;
        }
        int len = count / k;
        int remainder = count % k;
        ListNode cur = root;
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                break;
            }
            res[i] = cur;
            int thisLen = len;
            if (remainder > 0) {
                thisLen++;
                remainder--;
            }
            for (int j = 0; j < thisLen - 1; j++) {
                cur = cur.next;
            }
            ListNode nextNode = cur.next;
            cur.next = null;
            cur = nextNode;
        }
        return res;
    }

    class ListNode {
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
