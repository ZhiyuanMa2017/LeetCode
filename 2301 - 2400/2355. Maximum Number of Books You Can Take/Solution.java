import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        long res = 0;
        long[] dp = new long[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < n; right++) {
            while (!deque.isEmpty() && books[deque.peek()] >= books[right] - (right - deque.peek())) {
                deque.pop();
            }
            int len = deque.isEmpty() ? right + 1 : right - deque.peek();
            int start = books[right] - len + 1;
            long cur;
            if (start < 0) {
                cur = (long) books[right] * (books[right] + 1) / 2;
            } else {
                cur = (long) (books[right] + start) * len / 2;
            }

            if (!deque.isEmpty()) {
                cur += dp[deque.peek()];
            }
            dp[right] = cur;
            res = Math.max(res, cur);
            deque.push(right);
        }
        return res;
    }
}
