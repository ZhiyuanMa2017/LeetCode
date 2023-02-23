import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(projects, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        while (true) {
            while (index < n && projects[index][1] <= w) {
                pq.offer(projects[index][0]);
                index++;
            }
            if (k > 0 && !pq.isEmpty()) {
                w += pq.poll();
                k--;
            } else {
                break;
            }
        }
        return w;
    }
}
