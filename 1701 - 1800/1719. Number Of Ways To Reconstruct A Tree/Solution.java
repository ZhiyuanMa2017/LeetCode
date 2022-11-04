import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int checkWays(int[][] pairs) {
        boolean[][] graph = new boolean[501][501];
        int[] degree = new int[501];
        int[] parent = new int[501];
        Set<Integer> set = new HashSet<>();
        for (int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];
            graph[a][b] = true;
            graph[b][a] = true;
            degree[a]++;
            degree[b]++;
            set.add(a);
            set.add(b);
        }
        List<Integer> nodes = new ArrayList<>(set);
        Collections.sort(nodes, (a, b) -> degree[b] - degree[a]);
        int nodesNum = nodes.size();
        if (nodesNum - 1 > pairs.length) {
            return 0;
        }
        int root = nodes.get(0);
        if (degree[root] < nodesNum - 1) {
            return 0;
        }
        parent[root] = -1;
        for (int i = 1; i < nodesNum; i++) {
            int cur = nodes.get(i);
            boolean findParent = false;
            for (int j = i - 1; j >= 0; j--) {
                int p = nodes.get(j);
                if (graph[p][cur]) {
                    parent[cur] = p;
                    findParent = true;
                }
                if (findParent) {
                    break;
                }
            }
            if (!findParent) {
                return 0;
            }
        }
        int totalPaths = 0;
        int res = 1;
        for (Integer node : set) {
            int cur = node;
            while (parent[cur] != -1) {
                if (!graph[cur][parent[cur]]) {
                    return 0;
                }
                if (degree[cur] == degree[parent[cur]]) {
                    res = 2;
                }
                totalPaths++;
                cur = parent[cur];
            }
        }
        return totalPaths == pairs.length ? res : 0;
    }
}
