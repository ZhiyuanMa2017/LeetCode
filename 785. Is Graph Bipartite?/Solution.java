import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            if (color[i] != 0) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                int nextColor = color[cur] * -1;
                for (int j : graph[cur]) {
                    if (color[j] == nextColor) {
                        continue;
                    }
                    if (color[j] == color[cur]) {
                        return false;
                    }
                    color[j] = nextColor;
                    q.offer(j);
                }
            }
        }

        return true;
    }
}
