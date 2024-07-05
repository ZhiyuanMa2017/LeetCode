class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = 0;
        int last = 0;
        int minD = Integer.MAX_VALUE;
        int i = 1;
        ListNode cur = head.next;
        int prev = head.val;
        while (cur.next != null) {
            if ((prev > cur.val && cur.val < cur.next.val)
                    || (prev < cur.val && cur.val > cur.next.val)) {
                if (first == 0) {
                    first = i;
                }
                if (last != 0) {
                    minD = Math.min(minD, i - last);
                }
                last = i;
            }
            i++;
            prev = cur.val;
            cur = cur.next;
        }
        if (minD == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{minD, last - first};
    }
}
