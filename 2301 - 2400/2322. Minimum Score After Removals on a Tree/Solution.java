import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> graph;
    boolean[] visited;
    int[] score;
    List<Set<Integer>> children;
    int[] ns;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        visited = new boolean[n];
        score = new int[n];
        children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new HashSet<>());
        }
        ns = nums;
        visited[0] = true;
        dfs(0);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ii;
                int jj;
                int oo;
                if (children.get(j).contains(i)) {
                    ii = score[i];
                    jj = score[j] ^ score[i];
                    oo = score[0] ^ score[j];
                } else if (children.get(i).contains(j)) {
                    ii = score[i] ^ score[j];
                    jj = score[j];
                    oo = score[0] ^ score[i];
                } else {
                    ii = score[i];
                    jj = score[j];
                    oo = score[0] ^ score[i] ^ score[j];
                }
                res = Math.min(res, Math.max(oo, Math.max(ii, jj)) - Math.min(oo, Math.min(ii, jj)));
            }
        }
        return res;
    }

    private void dfs(int cur) {
        score[cur] = ns[cur];
        children.get(cur).add(cur);
        for (Integer neighbor : graph.get(cur)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(neighbor);
                score[cur] ^= score[neighbor];
                children.get(cur).addAll(children.get(neighbor));
            }
        }
    }
}
