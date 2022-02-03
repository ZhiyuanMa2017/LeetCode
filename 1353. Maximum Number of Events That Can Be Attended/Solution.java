import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for (int i = 1; i <= 100000; i++) {
            if (index == events.length) {
                break;
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            while (index < events.length && events[index][0] == i) {
                pq.offer(events[index][1]);
                index++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}
