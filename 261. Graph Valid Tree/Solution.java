import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        seen.add(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (Integer newNode : graph.get(node)) {
                    if (seen.contains(newNode)) {
                        continue;
                    }
                    seen.add(newNode);
                    queue.offer(newNode);
                }
            }
        }
        return seen.size() == n;
    }
}
