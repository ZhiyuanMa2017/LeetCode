class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int max = 0;
        int res = -1;
        for (int i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int t = logs[i][1];
            if (i > 0) {
                t -= logs[i - 1][1];
            }
            if (t > max) {
                res = id;
                max = t;
            } else if (t == max) {
                res = Math.min(res, id);
            }
        }
        return res;
    }
}
