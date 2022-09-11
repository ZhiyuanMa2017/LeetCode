import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (pq.isEmpty()) {
                pq.offer(right);
            } else if (left <= pq.peek()) {
                pq.offer(right);
            } else {
                pq.poll();
                pq.offer(right);
            }
        }
        return pq.size();
    }
}
