import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        int[] nodeToOrder = new int[n];
        Arrays.fill(nodeToOrder, -2);
        int[] orderToNode = new int[n];
        boolean[] circle = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        nodeToOrder[0] = 0;
        orderToNode[0] = 0;
        dfs(0, nodeToOrder, orderToNode, circle, graph);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (circle[i]) {
                queue.offer(i);
                res[i] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (Integer next : graph.get(cur)) {
                    if (res[next] == -1) {
                        res[next] = res[cur] + 1;
                        queue.offer(next);
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int node, int[] nodeToOrder, int[] orderToNode, boolean[] circle, List<List<Integer>> graph) {
        int curOrder = nodeToOrder[node];
        for (Integer next : graph.get(node)) {
            if (nodeToOrder[next] == curOrder - 1) {
                continue;
            }
            if (nodeToOrder[next] != -2) {
                for (int i = nodeToOrder[next]; i <= curOrder; i++) {
                    int n = orderToNode[i];
                    circle[n] = true;
                }
            } else {
                int order = curOrder + 1;
                nodeToOrder[next] = order;
                orderToNode[order] = next;
                dfs(next, nodeToOrder, orderToNode, circle, graph);
                orderToNode[order] = -1;
            }
        }
    }
}
