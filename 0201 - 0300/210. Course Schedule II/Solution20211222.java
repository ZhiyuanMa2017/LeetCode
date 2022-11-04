import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution20211222 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            inDegree[p[1]]++;
            graph.get(p[0]).add(p[1]);
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for (Integer next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        if (res.size() != numCourses) {
            return new int[]{};
        }
        int[] result = new int[res.size()];
        for (int i = numCourses - 1; i >= 0; i--) {
            result[numCourses - i - 1] = res.get(i);
        }
        return result;
    }
}
