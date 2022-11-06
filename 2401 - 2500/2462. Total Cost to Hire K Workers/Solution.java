import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int left = 0;
        int right = costs.length - 1;
        for (int i = 0; i < candidates; i++) {
            pq.offer(new int[]{costs[i], -1});
            left++;
        }
        for (int i = 0; i < candidates; i++) {
            if (right < left) {
                break;
            }
            pq.offer(new int[]{costs[costs.length - 1 - i], 1});
            right--;
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            int[] cur = pq.poll();
            res += cur[0];
            System.out.println(cur[0]);
            if (cur[1] == -1) {
                if (left <= right) {
                    pq.offer(new int[]{costs[left], -1});
                    left++;
                }
            } else {
                if (left <= right) {
                    pq.offer(new int[]{costs[right], 1});
                    right--;
                }
            }
        }
        return res;
    }
}
