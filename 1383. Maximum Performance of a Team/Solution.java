import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }
        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        long res = 0;
        long sumSpeed = 0;
        for (int[] engineer : engineers) {
            pq.add(engineer[1]);
            sumSpeed += engineer[1];
            if (pq.size() > k) {
                sumSpeed -= pq.poll();
            }
            res = Math.max(res, sumSpeed * engineer[0]);
        }
        return (int) (res % (long) (1e9 + 7));
    }
}
