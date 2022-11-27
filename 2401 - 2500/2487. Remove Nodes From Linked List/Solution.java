import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int n = list.size();
        int[] nextGreat = new int[n];
        nextGreat[n - 1] = 0;
        for (int i = list.size() - 2; i >= 0; i--) {
            nextGreat[i] = Math.max(nextGreat[i + 1], list.get(i + 1));
        }
        ListNode sentinel = new ListNode(-1);
        cur = sentinel;
        int index = 0;
        while (head != null) {
            if (head.val >= nextGreat[index]) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
            index++;
        }
        return sentinel.next;
    }
}
