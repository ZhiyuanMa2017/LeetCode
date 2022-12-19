import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        HashSet<Integer>[] graph = new HashSet[n + 1];
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            graph[from].add(to);
            graph[to].add(from);
            degree[from]++;
            degree[to]++;
        }
        List<Integer> odd = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 != 0) {
                odd.add(i);
            }
        }
        if (odd.size() == 0) {
            return true;
        } else if (odd.size() == 2) {
            int a = odd.get(0);
            int b = odd.get(1);
            for (int i = 1; i <= n; i++) {
                if (!graph[i].contains(a) && !graph[i].contains(b)) {
                    return true;
                }
            }
            return false;
        } else if (odd.size() == 4) {
            int a = odd.get(0);
            int b = odd.get(1);
            int c = odd.get(2);
            int d = odd.get(3);
            if (!graph[a].contains(b) && !graph[c].contains(d)) {
                return true;
            }
            if (!graph[a].contains(c) && !graph[b].contains(d)) {
                return true;
            }
            if (!graph[a].contains(d) && !graph[b].contains(c)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
