import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private List<Integer> topologicalSort(int k, int[][] conditions) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[k + 1];
        for (int[] condition : conditions) {
            int up = condition[0];
            int down = condition[1];
            inDegree[down]++;
            graph.get(up).add(down);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            list.add(cur);
            for (Integer next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return list;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rows = topologicalSort(k, rowConditions);
        List<Integer> cols = topologicalSort(k, colConditions);
        int[][] res = new int[k][k];
        if (rows.size() < k || cols.size() < k) {
            return new int[][]{};
        }
        int[] toX = new int[k + 1];
        for (int i = 0; i < k; i++) {
            int val = rows.get(i);
            toX[val] = i;
        }
        for (int j = 0; j < k; j++) {
            int val = cols.get(j);
            int x = toX[val];
            res[x][j] = val;
        }
        return res;
    }
}
