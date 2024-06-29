import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];
        List<Set<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            res.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] added = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer next : graph.get(cur)) {
                res.get(next).addAll(res.get(cur));
                res.get(next).add(cur);
                degree[next]--;
                if (degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>(res.get(i));
            Collections.sort(cur);
            result.add(cur);
        }
        return result;
    }
}
