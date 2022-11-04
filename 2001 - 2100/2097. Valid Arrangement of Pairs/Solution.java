import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int[] pair : pairs) {
            adj.putIfAbsent(pair[0], new ArrayList<>());
            adj.get(pair[0]).add(pair[1]);
            indegree.put(pair[0], indegree.getOrDefault(pair[0], 0) + 1);
            indegree.put(pair[1], indegree.getOrDefault(pair[1], 0) - 1);

        }

        int start = -1;
        for (Integer key : indegree.keySet()) {
            if (indegree.get(key) > 0) {
                start = key;
            }
        }

        if (start == -1) {
            start = pairs[0][0];
        }

        dfs(start);

        int[][] result = new int[pairs.length][pairs[0].length];

        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(ans.size() - i - 1).get(0);
            result[i][1] = ans.get(ans.size() - i - 1).get(1);
        }
        return result;
    }

    private void dfs(int node) {
        while (adj.get(node) != null && adj.get(node).size() > 0) {
            List<Integer> nodes = adj.get(node);
            int next = nodes.get(nodes.size() - 1);
            adj.get(node).remove(nodes.size() - 1);
            dfs(next);
            ans.add(Arrays.asList(node, next));
        }
    }
}
