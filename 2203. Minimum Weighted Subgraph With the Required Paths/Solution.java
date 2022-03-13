import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.get(from).add(new int[]{to, weight});
            reverseGraph.get(to).add(new int[]{from, weight});
        }
        long[] src1To = new long[n];
        long[] src2To = new long[n];
        Arrays.fill(src1To, Long.MAX_VALUE);
        Arrays.fill(src2To, Long.MAX_VALUE);

        dijkstra(graph, src1, src1To);
        dijkstra(graph, src2, src2To);
        if (src1To[dest] == Long.MAX_VALUE || src2To[dest] == Long.MAX_VALUE) {
            return -1;
        }
        long[] destTo = new long[n];
        Arrays.fill(destTo, Long.MAX_VALUE);
        dijkstra(reverseGraph, dest, destTo);
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (src1To[i] == Long.MAX_VALUE || src2To[i] == Long.MAX_VALUE || destTo[i] == Long.MAX_VALUE) {
                continue;
            }
            res = Math.min(res, src1To[i] + src2To[i] + destTo[i]);
        }
        return res;
    }

    private void dijkstra(List<List<int[]>> graph, int start, long[] dis) {
        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        priorityQueue.offer(new long[]{start, 0});
        while (!priorityQueue.isEmpty()) {
            long[] cur = priorityQueue.poll();
            int index = (int) cur[0];
            if (dis[index] != Long.MAX_VALUE) {
                continue;
            }
            dis[index] = cur[1];
            for (int[] next : graph.get(index)) {
                int neighbor = next[0];
                if (dis[neighbor] != Long.MAX_VALUE) {
                    continue;
                }
                priorityQueue.add(new long[]{neighbor, next[1] + dis[index]});
            }
        }
    }
}
