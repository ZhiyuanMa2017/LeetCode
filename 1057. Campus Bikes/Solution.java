import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]>[] bucket = new ArrayList[2000];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dis = getDis(workers[i], bikes[j]);
                if (bucket[dis] == null) {
                    bucket[dis] = new ArrayList<>();
                }
                bucket[dis].add(new int[]{i, j});
            }
        }
        boolean[] used = new boolean[1001];
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        int count = 0;
        for (int i = 0; i < 2000; i++) {
            if (bucket[i] == null) {
                continue;
            }
            for (int[] ints : bucket[i]) {
                int w = ints[0];
                int b = ints[1];
                if (res[w] == -1 && !used[b]) {
                    res[w] = b;
                    used[b] = true;
                    count++;
                }
            }
            if (count == res.length) {
                break;
            }
        }
        return res;
    }

    private int getDis(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }
}
