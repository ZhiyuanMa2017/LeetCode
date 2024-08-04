import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            map.put(i, i + 1);
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (!map.containsKey(l) || map.get(l) >= r) {
                res[i] = map.size();
            } else {
                int u = map.get(l);
                while (u < r) {
                    u = map.remove(u);
                }
                map.put(l, u);
                res[i] = map.size();
            }
        }
        return res;
    }
}
