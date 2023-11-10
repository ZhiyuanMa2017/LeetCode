import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int a = pair[0];
            int b = pair[1];
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int start = 0;
        for (Integer key : graph.keySet()) {
            if (graph.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        int[] res = new int[adjacentPairs.length + 1];
        res[0] = start;
        res[1] = graph.get(start).get(0);
        for (int i = 2; i < res.length; i++) {
            int v = res[i - 1];
            for (Integer next : graph.get(v)) {
                if (next != res[i - 2]) {
                    res[i] = next;
                    break;
                }
            }
        }
        return res;
    }
}
