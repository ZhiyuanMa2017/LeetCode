class Solution {
    public int pairSum(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        int n = l.size();
        int res = 0;
        for (int i = 0; i <= n / 2 - 1; i++) {
            res = Math.max(res, l.get(i) + l.get(n - i - 1));
        }
        return res;
    }
}
