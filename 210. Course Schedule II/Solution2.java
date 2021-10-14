import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<List<Integer>> graph;
    int[] visited;
    List<Integer> order;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        order = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 0 -> 1
        for (int[] pres : prerequisites) {
            inDegree[pres[1]]++;
            graph.get(pres[0]).add(pres[1]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    //  1: visited this round
    // -1: visited in other round, so just skip
    // true: find a circle
    private boolean dfs(int i) {
        if (visited[i] == 1) {
            return true;
        }
        if (visited[i] == -1) {
            return false;
        }
        visited[i] = 1;
        for (int first : graph.get(i)) {
            if (dfs(first)) {
                return true;
            }
        }
        visited[i] = -1;
        order.add(i);
        return false;
    }
}
