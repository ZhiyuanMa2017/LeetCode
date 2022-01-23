class Solution {

    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int maxBitmask = 1 << n;
        int res = 0;
        for (int i = 1; i < maxBitmask; i++) {
            int cur = valid(i, statements);
            res = Math.max(cur, res);
        }
        return res;
    }

    private int valid(int mask, int[][] statements) {
        int count = 0;
        int n = statements.length;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) > 0) {
                for (int j = 0; j < n; j++) {
                    if (statements[i][j] == 0 && ((1 << j) & mask) > 0) {
                        return -1;
                    }
                    if (statements[i][j] == 1 && ((1 << j) & mask) == 0) {
                        return -1;
                    }
                }
                count++;
            }
        }
        return count;
    }
}
