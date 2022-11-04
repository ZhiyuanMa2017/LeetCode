import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int d = 0;
            int cur = i;
            Map<Integer, Integer> dis = new HashMap<>();
            while (cur != -1) {
                if (dis.containsKey(cur)) {
                    res = Math.max(res, d - dis.get(cur));
                    break;
                }
                if (visited[cur]) {
                    break;
                }
                visited[cur] = true;
                dis.put(cur, d);
                d++;
                cur = edges[cur];
            }
        }
        return res;
    }
}
