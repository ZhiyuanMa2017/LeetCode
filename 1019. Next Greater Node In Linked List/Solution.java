import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] next = new int[list.size()];
        next[next.length - 1] = -1;
        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                next[i] = i + 1;
            } else {
                int j = i + 1;
                while (j != -1 && list.get(i) >= list.get(j)) {
                    j = next[j];
                }
                next[i] = j;
            }
        }
        int[] res = new int[next.length];
        for (int i = 0; i < next.length; i++) {
            if (next[i] == -1) {
                res[i] = 0;
            } else {
                res[i] = list.get(next[i]);
            }

        }
        return res;
    }
}
