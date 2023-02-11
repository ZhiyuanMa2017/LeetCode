import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] graph = new ArrayList[n][2];
        for (int i = 0; i < n; i++) {
            graph[i][0] = new ArrayList<>();
            graph[i][1] = new ArrayList<>();
        }
        for (int[] redEdge : redEdges) {
            graph[redEdge[0]][0].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            graph[blueEdge[0]][1].add(blueEdge[1]);
        }
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        visited[0][1] = true;
        int d = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int node = cur[0];
                int color = cur[1];
                if (dis[node] == -1) {
                    dis[node] = d;
                }
                color ^= 1;
                for (Integer next : graph[node][color]) {
                    if (!visited[next][color]) {
                        queue.offer(new int[]{next, color});
                        visited[next][color] = true;
                    }
                }
            }
            d++;
        }
        return dis;
    }
}
