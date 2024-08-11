class Solution2 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int cur = 1;
        int p = 0;
        while (cur <= n * n) {
            res[x][y] = cur;
            cur++;
            int i = x + dirs[p];
            int j = y + dirs[p + 1];
            if (i < 0 || j < 0 || i >= n || j >= n || res[i][j] != 0) {
                p = (p + 1) % 4;
                i = x + dirs[p];
                j = y + dirs[p + 1];
            }
            x = i;
            y = j;
        }
        return res;
    }
}
