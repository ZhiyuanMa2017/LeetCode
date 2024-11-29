import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            inDegree[u]++;
            inDegree[v]++;
        }
        boolean[] leaf = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.offer(i);
                leaf[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 1) {
                    queue.offer(next);
                    leaf[next] = true;
                }
            }
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Queue<Integer> queue2 = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!leaf[i]) {
                queue2.offer(i);
                res[i] = 0;
            }
        }
        while (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size; i++) {
                int cur = queue2.poll();
                for (Integer next : graph.get(cur)) {
                    if (res[next] == -1) {
                        res[next] = res[cur] + 1;
                        queue2.offer(next);
                    }
                }
            }
        }
        return res;
    }
}
