import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] highway : highways) {
            int u = highway[0];
            int v = highway[1];
            int toll = highway[2];
            graph.get(u).add(new int[]{v, toll});
            graph.get(v).add(new int[]{u, toll});
        }
        int[][] dis = new int[n][discounts + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int city = cur[1];
            int usedDiscount = cur[2];
            if (city == n - 1) {
                return cost;
            }
            if (cost > dis[city][usedDiscount]) {
                continue;
            }
            for (int[] next : graph.get(city)) {
                int nextCity = next[0];
                int nextToll = next[1];
                if (cost + nextToll < dis[nextCity][usedDiscount]) {
                    dis[nextCity][usedDiscount] = cost + nextToll;
                    pq.offer(new int[]{dis[nextCity][usedDiscount], nextCity, usedDiscount});
                }
                if (usedDiscount < discounts) {
                    if (cost + nextToll / 2 < dis[nextCity][usedDiscount + 1]) {
                        dis[nextCity][usedDiscount + 1] = cost + nextToll / 2;
                        pq.offer(new int[]{dis[nextCity][usedDiscount + 1], nextCity, usedDiscount + 1});
                    }
                }
            }
        }
        return -1;
    }
}
