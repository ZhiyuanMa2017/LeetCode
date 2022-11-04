import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int weight = time[2];
            graph.get(source).add(new int[]{target, weight});
        }
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{k, 0});
        int count = 0;
        int res = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visited[cur[0]]) {
                continue;
            }
            res = cur[1];
            count++;
            visited[cur[0]] = true;
            for (int[] next : graph.get(cur[0])) {
                int dis = next[1] + cur[1];
                q.offer(new int[]{next[0], dis});
            }
        }
        if (count == n) {
            return res;
        }
        return -1;
    }
}
