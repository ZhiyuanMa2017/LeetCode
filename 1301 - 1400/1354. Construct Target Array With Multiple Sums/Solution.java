import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for (int t : target) {
            sum += t;
            pq.offer((long) t);
        }

        while (true) {
            long curMax = pq.poll();
            sum -= curMax;
            if (curMax == 1 || sum == 1) {
                return true;
            }
            if (sum > curMax || sum == 0 || curMax % sum == 0) {
                return false;
            }
            curMax %= sum;
            pq.offer(curMax);
            sum += curMax;
        }
    }
}
