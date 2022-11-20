import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> graph;
    long res;
    int s;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        s = seats;
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(0, -1);
        return res;
    }

    private int dfs(int cur, int parent) {
        int size = 1;
        for (Integer next : graph.get(cur)) {
            if (next != parent) {
                size += dfs(next, cur);
            }
        }
        if (cur != 0) {
            res += (size + s - 1) / s;
        }
        return size;
    }
}
