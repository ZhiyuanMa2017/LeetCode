import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<List<Integer>> graph;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // pres: 0 -> 1
        for (int[] pres : prerequisites) {
            graph.get(pres[0]).add(pres[1]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i)) {
                return false;
            }
        }
        return true;
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
        return false;
    }
}
