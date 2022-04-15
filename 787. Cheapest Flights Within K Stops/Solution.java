import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis, 10000 * 100 + 1);
        dis[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            int[] old = dis.clone();
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                dis[to] = Math.min(dis[to], old[from] + price);
            }
        }
        return dis[dst] == 10000 * 100 + 1 ? -1 : dis[dst];
    }
}
