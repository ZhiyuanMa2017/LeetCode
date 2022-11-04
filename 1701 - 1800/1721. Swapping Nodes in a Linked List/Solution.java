import java.util.List;
import java.util.ArrayList;

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> arrayList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        int first = arrayList.get(k - 1);
        int last = arrayList.get(arrayList.size() - k);
        arrayList.set(arrayList.size() - k, first);
        arrayList.set(k - 1, last);

        ListNode sentinel = new ListNode(0, null);
        ListNode h = sentinel;
        for (int i = 0; i < arrayList.size(); i++) {
            h.next = new ListNode(arrayList.get(i), null);
            h = h.next;
        }
        return sentinel.next;
    }
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
