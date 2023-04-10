import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = colors.charAt(i) - 'a';
        }
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            int f = edge[0];
            int t = edge[1];
            graph[f].add(t);
            inDegree[t]++;
        }
        int[][] dp = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        int seen = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                dp[i][c[i]]++;
                seen++;
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res = Math.max(res, dp[cur][c[cur]]);
            for (Integer next : graph[cur]) {
                for (int i = 0; i < 26; i++) {
                    dp[next][i] = Math.max(dp[next][i], dp[cur][i]);
                }
                dp[next][c[next]] = Math.max(dp[next][c[next]], dp[cur][c[next]] + 1);
                if (inDegree[next] == 1) {
                    queue.offer(next);
                    seen++;
                }
                inDegree[next]--;
            }
        }
        if (seen < n) {
            return -1;
        }
        return res;
    }
}
