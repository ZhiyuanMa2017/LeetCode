import java.util.Arrays;

class Solution2 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = rectangles.length, Q = points.length;
        int[][] es = new int[n + Q][];
        for (int i = 0; i < n; i++) {
            es[i] = rectangles[i];
        }
        for (int i = 0; i < Q; i++) {
            es[n + i] = new int[]{points[i][0], points[i][1], i};
        }
        Arrays.sort(es, (x, y) -> {
            if (x[0] != y[0]) {
                return -(x[0] - y[0]);
            }
            return x.length - y.length;
        });
        int[] ct = new int[101];
        int[] ans = new int[Q];
        for (int[] e : es) {
            if (e.length == 2) {
                for (int i = 0; i <= e[1]; i++) {
                    ct[i]++;
                }
            } else {
                ans[e[2]] = ct[e[1]];
            }
        }
        return ans;
    }
}
