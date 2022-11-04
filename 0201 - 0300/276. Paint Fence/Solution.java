class Solution {
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        int twoBack = k;
        int oneBack = k * k;
        for (int i = 3; i <= n; i++) {
            int cur = (k - 1) * (twoBack + oneBack);
            twoBack = oneBack;
            oneBack = cur;
        }
        return oneBack;
    }
}
