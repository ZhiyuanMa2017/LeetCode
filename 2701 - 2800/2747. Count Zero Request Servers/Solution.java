import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        int[][] qs = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            qs[i] = new int[]{queries[i], i};
        }
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        int right = 0;
        int left = 0;
        int[] count = new int[n + 1];
        int cur = 0;
        int[] res = new int[queries.length];
        for (int[] q : qs) {
            int time = q[0];
            int index = q[1];
            while (right < logs.length && logs[right][1] <= time) {
                int server = logs[right][0];
                if (count[server] == 0) {
                    cur++;
                }
                count[server]++;
                right++;
            }
            while (left < right && logs[left][1] + x < time) {
                int server = logs[left][0];
                count[server]--;
                if (count[server] == 0) {
                    cur--;
                }
                left++;
            }
            res[index] = n - cur;
        }
        return res;
    }
}
