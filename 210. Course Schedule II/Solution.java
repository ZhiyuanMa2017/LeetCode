import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 0 -> 1
        for (int[] pres : prerequisites) {
            inDegree[pres[1]]++;
            graph.get(pres[0]).add(pres[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int second = q.poll();
            res.add(second);
            // here: second -> first
            for (int first : graph.get(second)) {
                inDegree[first]--;
                if (inDegree[first] == 0) {
                    q.offer(first);
                }
            }
        }
        if (res.size() != numCourses) {
            return new int[numCourses];
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(numCourses - 1 - i);
        }
        return result;
    }
}
