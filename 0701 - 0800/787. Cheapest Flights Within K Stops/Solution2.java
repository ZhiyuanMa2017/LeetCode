import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[]{to, price});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0});
        dis[src] = 0;
        int step = 0;
        while (step <= k && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int flight = cur[0];
                int d = cur[1];
                for (int[] ints : graph.get(flight)) {
                    int next = ints[0];
                    int price = ints[1];
                    if (d + price < dis[next]) {
                        dis[next] = d + price;
                        queue.offer(new int[]{next, dis[next]});
                    }
                }
            }
            step++;
        }
        if (dis[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dis[dst];
    }
}
