import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        UF uf = new UF(n + 1);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a][b] = true;
            graph[b][a] = true;
            uf.union(a, b);
        }
        int res = 0;
        Map<Integer, Integer> pToV = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int p = uf.find(i);
            int cur = bfs(graph, i);
            if (cur == -1) {
                return -1;
            }
            pToV.put(p, Math.max(cur, pToV.getOrDefault(p, 0)));
        }
        for (Integer value : pToV.values()) {
            res += value;
        }
        return res;
    }

    private int bfs(boolean[][] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int n = graph.length;
        n -= 1;
        int[] level = new int[n + 1];
        level[start] = 1;
        int res = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j <= n; j++) {
                    if (graph[cur][j]) {
                        if (level[j] == 0) {
                            level[j] = level[cur] + 1;
                            queue.offer(j);
                        } else {
                            if (level[j] == level[cur] + 1 || level[j] == level[cur] - 1) {
                                continue;
                            } else {
                                return -1;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    class UF {
        int[] parent;
        int[] size;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (q == p) {
                return;
            }
            if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}
