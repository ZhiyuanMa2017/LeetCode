import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    Set<Long> set;
    int BOUND;
    long BASE = 1000000L;
    int[] DIRS = new int[]{-1, 0, 1, 0, -1};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;
        set = new HashSet<>();
        BOUND = n * (n - 1) / 2;
        for (int[] b : blocked) {
            set.add(b[0] * BASE + b[1]);
        }
        return bfs(source, target) && bfs(target, source);
    }

    private boolean bfs(int[] source, int[] target) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(source);
        visited.add(source[0] * BASE + source[1]);
        while (!q.isEmpty() && visited.size() <= BOUND) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + DIRS[i];
                int y = cur[1] + DIRS[i + 1];
                if (x == target[0] && y == target[1]) {
                    return true;
                }
                if (x >= 0 && x < BASE && y >= 0 && y < BASE) {
                    long hash = x * BASE + y;
                    if (!visited.contains(hash) && !set.contains(hash)) {
                        q.offer(new int[]{x, y});
                        visited.add(hash);
                    }
                }

            }
        }
        return visited.size() > BOUND;
    }
}
