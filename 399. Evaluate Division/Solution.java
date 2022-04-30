import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];
            if (!graph.containsKey(a)) {
                graph.put(a, new HashMap<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new HashMap<>());
            }
            graph.get(a).put(b, v);
            graph.get(b).put(a, 1 / v);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = bfs(queries.get(i), graph);
        }
        return res;
    }

    private double bfs(List<String> query, Map<String, Map<String, Double>> graph) {
        String a = query.get(0);
        String b = query.get(1);
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1;
        }
        if (a.equals(b)) {
            return 1;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a, 1));
        Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited.add(cur.s);
            if (cur.s.equals(b)) {
                return cur.v;
            }
            for (String next : graph.get(cur.s).keySet()) {
                if (visited.contains(next)) {
                    continue;
                }
                q.offer(new Node(next, graph.get(cur.s).get(next) * cur.v));
            }
        }
        return -1;
    }

    class Node {
        String s;
        double v;

        Node(String ss, double vv) {
            s = ss;
            v = vv;
        }
    }
}
