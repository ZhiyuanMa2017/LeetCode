import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // pres 0 -> 1
        for (int[] pres : prerequisites) {
            inDegree[pres[1]]++;
            graph.get(pres[0]).add(pres[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = numCourses;
        while (!q.isEmpty()) {
            int second = q.poll();
            count--;
            for (int first : graph.get(second)) {
                inDegree[first]--;
                if (inDegree[first] == 0) {
                    q.offer(first);
                }
            }
        }
        return count == 0;
    }
}
