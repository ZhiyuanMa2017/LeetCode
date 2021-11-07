import java.util.ArrayList;
import java.util.List;


class Solution {

    static int res;
    List<int[]>[] graph;
    int[] valuesArray;
    int[] visited;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        res = values[0];
        visited = new int[values.length];
        graph = new List[values.length];
        for (int i = 0; i < values.length; i++) {
            graph[i] = new ArrayList<>();
        }


        valuesArray = values;
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        visited[0]++;
        backtrack(0, values[0], maxTime);
        return res;
    }

    private void backtrack(int node, int curValue, int remainTime) {
        if (node == 0) {
            res = Math.max(res, curValue);
        }
        for (int[] edge : graph[node]) {
            if (remainTime < edge[1]) {
                continue;
            }
            visited[edge[0]]++;
            backtrack(edge[0], visited[edge[0]] == 1 ? curValue + valuesArray[edge[0]] : curValue, remainTime - edge[1]);
            visited[edge[0]]--;
        }
    }
}
