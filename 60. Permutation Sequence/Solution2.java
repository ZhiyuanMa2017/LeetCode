public class Solution2 {
    private static final int[] factorial = new int[10];

    public String getPermutation(int n, int k) {
        factorial[0] = 1;
        for (int i = 1; i <= 9; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int cnt = factorial[i];
            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (k > cnt) {
                    k -= cnt;
                    continue;
                }
                visited[j] = true;
                sb.append(j);
                break;
            }
        }
        return sb.toString();
    }
}
