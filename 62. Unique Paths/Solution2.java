class Solution2 {
    public int uniquePaths(int m, int n) {
        long res = 1;
        // n + m - 2 选 m -1
        // combination
        for (int i = 1; i < m; i++) {
            res = res * (n - 1 + i) / i;
        }
        return (int) res;
    }
}
