class Solution {
    private boolean[] used;
    private int[] factorial;
    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        return sb.toString();
    }

    private void dfs(int index, StringBuilder sb) {
        if (index == n) {
            return;
        }
        int cnt = factorial[n - index - 1];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (k > cnt) {
                k -= cnt;
                continue;
            }
            sb.append(i);
            used[i] = true;
            dfs(index + 1, sb);
            return;
        }
    }
}
