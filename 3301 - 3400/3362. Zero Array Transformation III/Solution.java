import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int cur = 0;
        int used = 0;
        int j = 0;
        int[] line = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cur += line[i];
            while (j < queries.length && queries[j][0] <= i) {
                pq.offer(queries[j][1]);
                j++;
            }
            while (cur < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                cur++;
                used++;
                line[pq.poll() + 1]--;
            }
            if (cur < nums[i]) {
                return -1;
            }
        }
        return m - used;
    }
}
