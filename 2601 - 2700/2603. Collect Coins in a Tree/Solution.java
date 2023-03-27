import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (coins[i] == 0 && graph[i].size() == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer next : graph[cur]) {
                graph[next].remove(cur);
                if (graph[next].size() == 1 && coins[next] == 0) {
                    queue.offer(next);
                }
            }
            graph[cur].clear();
        }
        for (int iteration = 0; iteration < 2; iteration++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (graph[i].size() == 1) {
                    list.add(i);
                }
            }
            for (Integer cur : list) {
                for (Integer next : graph[cur]) {
                    graph[next].remove(cur);
                }
                graph[cur].clear();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i].size() > 0) {
                count++;
            }
        }
        int edge = count - 1;
        if (edge <= 0) {
            return 0;
        } else {
            return edge * 2;
        }
    }
}
