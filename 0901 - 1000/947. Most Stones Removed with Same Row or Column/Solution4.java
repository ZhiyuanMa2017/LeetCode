import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        Map<Integer, List<Integer>> x = new HashMap<>();
        Map<Integer, List<Integer>> y = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = stones[i][0];
            int b = stones[i][1];
            if (!x.containsKey(a)) {
                x.put(a, new ArrayList<>());
            }
            if (!y.containsKey(b)) {
                y.put(b, new ArrayList<>());
            }
            x.get(a).add(i);
            y.get(b).add(i);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            res += dfs(i, x, y, stones, visited) - 1;
        }
        return res;
    }

    private int dfs(int index, Map<Integer, List<Integer>> x, Map<Integer, List<Integer>> y, int[][] stones, boolean[] visited) {
        int res = 1;
        int a = stones[index][0];
        int b = stones[index][1];
        visited[index] = true;
        for (Integer next : x.get(a)) {
            if (!visited[next]) {
                res += dfs(next, x, y, stones, visited);
            }
        }
        for (Integer next : y.get(b)) {
            if (!visited[next]) {
                res += dfs(next, x, y, stones, visited);
            }
        }
        return res;
    }
}
