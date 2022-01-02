import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxCircle;
    int n;
    List<List<Integer>> graph;
    List<int[]> pairs;

    public int maximumInvitations(int[] favorite) {
        n = favorite.length;
        graph = new ArrayList<>();
        pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (i == favorite[favorite[i]]) {
                if (i < favorite[i]) {
                    pairs.add(new int[]{i, favorite[i]});
                }
            } else {
                graph.get(favorite[i]).add(i);
            }
        }

        int sumPath = 0;
        boolean[] visited = new boolean[n];
        for (int[] pair : pairs) {
            int p1 = pair[0];
            int p2 = pair[1];
            int pathOne = extend(p1, visited);
            int pathTwo = extend(p2, visited);

            sumPath += pathOne + pathTwo;
        }

        maxCircle = 0;
        getMaxCircle(visited);

        return Math.max(maxCircle, sumPath);
    }

    private int extend(int index, boolean[] visited) {
        visited[index] = true;
        int res = 0;
        for (Integer next : graph.get(index)) {
            visited[next] = true;
            int depth = extend(next, visited);
            res = Math.max(res, depth);
        }
        return res + 1;
    }

    private void getMaxCircle(boolean[] visited) {
        boolean[] visitedThisRound = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(visited, visitedThisRound, i, 0);
        }
    }

    private void dfs(boolean[] visited, boolean[] thisRound, int index, int count) {
        if (thisRound[index]) {
            maxCircle = Math.max(maxCircle, count);
            return;
        }
        if (visited[index]) {
            return;
        }
        visited[index] = true;
        thisRound[index] = true;
        for (Integer next : graph.get(index)) {
            dfs(visited, thisRound, next, count + 1);
        }
        thisRound[index] = false;
    }
}
