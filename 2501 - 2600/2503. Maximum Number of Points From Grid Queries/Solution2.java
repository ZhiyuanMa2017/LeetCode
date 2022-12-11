import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    PriorityQueue<int[]> pq;
    boolean[][] add;

    private int dfs(int x, int y, int[][] grid, int max) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 0;
        }
        if (add[x][y]) {
            return 0;
        }
        if (grid[x][y] > max) {
            pq.offer(new int[]{x, y, grid[x][y]});
            return 0;
        }
        add[x][y] = true;
        int count = 1;
        count += dfs(x + 1, y, grid, max);
        count += dfs(x - 1, y, grid, max);
        count += dfs(x, y + 1, grid, max);
        count += dfs(x, y - 1, grid, max);
        return count;
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        add = new boolean[m][n];
        pq.offer(new int[]{0, 0, grid[0][0]});
        Map<Integer, Integer> map = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int count = dfs(x, y, grid, grid[x][y]);
            map.put(grid[x][y], map.getOrDefault(grid[x][y], 0) + count);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int cur = 0;
        TreeMap<Integer, Integer> preSum = new TreeMap<>();
        for (int key : keys) {
            int value = map.get(key);
            cur += value;
            preSum.put(key, cur);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer floor = preSum.lowerKey(queries[i]);
            if (floor == null) {
                res[i] = 0;
            } else {
                res[i] = preSum.get(floor);
            }
        }
        return res;
    }
}
