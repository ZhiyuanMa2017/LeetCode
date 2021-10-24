import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            inDegree[relation[1]]++;
        }
        int[] totalTime = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                totalTime[i] = 0;
            }
        }
        int maxTime = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            maxTime = Math.max(maxTime, totalTime[cur] + time[cur - 1]);
            for (int i : graph.get(cur)) {
                totalTime[i] = Math.max(totalTime[i], totalTime[cur] + time[cur - 1]);
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return maxTime;
    }
}
