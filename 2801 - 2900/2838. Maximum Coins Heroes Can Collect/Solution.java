import java.util.Arrays;

class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int n = heroes.length;
        int m = monsters.length;
        int[][] mc = new int[m][2];
        for (int i = 0; i < m; i++) {
            mc[i] = new int[]{monsters[i], coins[i]};
        }
        Arrays.sort(mc, (a, b) -> a[0] - b[0]);
        long[] prefix = new long[m];
        prefix[0] = mc[0][1];
        for (int i = 1; i < m; i++) {
            prefix[i] = prefix[i - 1] + mc[i][1];
        }
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            if (heroes[i] < mc[0][0]) {
                res[i] = 0;
            } else if (heroes[i] > mc[m - 1][0]) {
                res[i] = prefix[m - 1];
            } else {
                int l = 0;
                int r = m - 1;
                while (l < r) {
                    int mid = l + (r - l + 1) / 2;
                    if (mc[mid][0] <= heroes[i]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                res[i] = prefix[l];
            }
        }
        return res;
    }
}
