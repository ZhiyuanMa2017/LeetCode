import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            inDegree[next]++;
            graph.get(prev).add(next);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int step = 0;
        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            coursesTaken += size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (Integer next : graph.get(cur)) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            step++;
        }
        if (coursesTaken == n) {
            return step;
        }
        return -1;
    }
}
