/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int preIndex = -1;
        int firstIndex = -1;
        int maxDistance = 0;
        int minDistance = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            if (i + 1 < list.size()) {
                if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                    if (preIndex == -1) {
                        preIndex = i;
                        firstIndex = i;
                        count++;
                    } else {
                        int dis = i - preIndex;
                        maxDistance = Math.max(maxDistance, i - firstIndex);
                        minDistance = Math.min(minDistance, dis);
                        preIndex = i;
                        count++;
                    }
                }
                if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                    if (preIndex == -1) {
                        preIndex = i;
                        firstIndex = i;
                        count++;
                    } else {
                        int dis = i - preIndex;
                        maxDistance = Math.max(maxDistance, i - firstIndex);
                        minDistance = Math.min(minDistance, dis);
                        preIndex = i;
                        count++;
                    }
                }
            }
        }
        if (count < 2) {
            return new int[]{-1, -1};
        }
        return new int[]{minDistance, maxDistance};

    }
}
