class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] sum = new long[n];
        for (int i = 0; i < n; i++) {
            int to = edges[i];
            sum[to] += i;
        }
        int index = 0;
        long max = sum[0];
        for (int i = 1; i < n; i++) {
            if (sum[i] > max) {
                index = i;
                max = sum[i];
            }
        }
        return index;
    }
}
