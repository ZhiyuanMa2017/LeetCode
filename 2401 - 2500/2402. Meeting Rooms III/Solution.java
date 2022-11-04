import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0});
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int[] meeting : meetings) {
            while (pq.peek()[1] < meeting[0]) {
                int[] cur = pq.poll();
                cur[1] = meeting[0];
                pq.offer(cur);
            }
            int[] cur = pq.poll();
            count[cur[0]]++;
            cur[1] += meeting[1] - meeting[0];
            pq.offer(cur);
        }
        int index = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                index = i;
                max = count[i];
            }
        }
        return index;
    }
}
