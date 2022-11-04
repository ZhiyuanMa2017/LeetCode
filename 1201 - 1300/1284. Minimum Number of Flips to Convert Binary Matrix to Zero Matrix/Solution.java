import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start |= (mat[i][j] << (i * n + j));
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        int[] dirs = new int[]{0, 1, 0, -1, 0, 0};
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.poll();
                if (cur == 0) {
                    return step;
                }
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int next = cur;
                        for (int p = 0; p < 5; p++) {
                            int x = i + dirs[p];
                            int y = j + dirs[p + 1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                next ^= 1 << (x * n + y);
                            }
                        }
                        if (!set.contains(next)) {
                            queue.offer(next);
                            set.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
