import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> no = new HashSet<>();
        for (int i : restricted) {
            no.add(i);
        }
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        no.add(0);
        int res = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer next : graph.get(node)) {
                if (!no.contains(next)) {
                    res++;
                    queue.offer(next);
                    no.add(node);

                }
            }
        }
        return res;
    }
}
