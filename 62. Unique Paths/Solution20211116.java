class Solution20211116 {
    public int uniquePaths(int m, int n) {
        long res = 1;
//        n + m - 1 中选 m -1，组合数
        for (int i = 1; i < m; i++) {
            res = res * (n - 1 + i) / i;
        }
        return (int) res;
    }
}
