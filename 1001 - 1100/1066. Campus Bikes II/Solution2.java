import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        Set<Integer> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dis = cur[0];
            int mask = cur[1];
            int index = Integer.bitCount(mask);
            if (index == n) {
                return dis;
            }
            if (visited.contains(mask)) {
                continue;
            }
            visited.add(mask);
            for (int i = 0; i < m; i++) {
                if ((mask >> i & 1) == 0) {
                    int d = cal(workers[index], bikes[i]);
                    pq.offer(new int[]{dis + d, mask | 1 << i});
                }
            }
        }
        return -1;
    }

    private int cal(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
