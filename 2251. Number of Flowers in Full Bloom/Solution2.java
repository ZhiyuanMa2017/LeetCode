import java.util.Arrays;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = flowers.length, Q = persons.length;
        int[][] es = new int[2 * n + Q][];
        for (int i = 0; i < n; i++) {
            es[i] = new int[]{flowers[i][0], 1};
            es[i + n] = new int[]{flowers[i][1] + 1, -1};
        }
        for (int i = 0; i < Q; i++) {
            es[i + 2 * n] = new int[]{persons[i], 0, i};
        }
        Arrays.sort(es, (x, y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            }
            return x.length - y.length;
        });
        int h = 0;
        int[] ans = new int[Q];
        for (int[] e : es) {
            if (e.length == 2) {
                h += e[1];
            } else {
                ans[e[2]] = h;
            }
        }
        return ans;
    }
}
