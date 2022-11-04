import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        int max = 0;
        for (int i = 0; i < arrival.length; i++) {
            int cur = arrival[i];
            int end = cur + load[i];
            while (!pq.isEmpty() && pq.peek()[1] <= cur) {
                free.add(pq.poll()[0]);
            }
            if (free.isEmpty()) {
                continue;
            }
            Integer ceiling = free.ceiling(i % k);
            Integer server = ceiling == null ? free.first() : ceiling;
            free.remove(server);
            pq.add(new int[]{server, end});
            count[server]++;
            max = Math.max(max, count[server]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
