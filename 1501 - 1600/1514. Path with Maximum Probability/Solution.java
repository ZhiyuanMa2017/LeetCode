import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new double[]{v, prob});
            graph.get(v).add(new double[]{u, prob});
        }
        double[] probs = new double[n];
        probs[start_node] = 1;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[1]));
        pq.offer(new double[]{start_node, 1});
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int u = (int) cur[0];
            double p = cur[1];
            if (u == end_node) {
                return p;
            }
            for (double[] neighbor : graph.get(u)) {
                int next = (int) neighbor[0];
                double pp = neighbor[1];
                if (p * pp > probs[next]) {
                    probs[next] = p * pp;
                    pq.offer(new double[]{next, p * pp});
                }
            }
        }
        return 0;
    }
}
