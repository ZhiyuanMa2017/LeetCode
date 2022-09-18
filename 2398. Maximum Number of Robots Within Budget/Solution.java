import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int res = 0;
        long sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
                deque.pollLast();
            }
            deque.addLast(right);
            sum += runningCosts[right];
            while (!deque.isEmpty() && chargeTimes[deque.peekFirst()] + sum * (right - left + 1) > budget) {
                sum -= runningCosts[left];
                if (deque.peekFirst() == left) {
                    deque.pollFirst();
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
