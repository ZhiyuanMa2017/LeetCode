import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int res = 0;
        int level = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[100001];
        visited[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                int time = 2 * level;
                for (int next : graph.get(cur)) {
                    if (!visited[next]) {
                        res = Math.max(res, (time - 1) / patience[next] * patience[next] + time);
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            level++;
        }
        return res + 1;

    }
}
