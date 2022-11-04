import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int step = 1;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int j = 0; j < 4; j++) {
                    int x1 = x + dirs[j];
                    int y1 = y + dirs[j + 1];
                    if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n) {
                        if (rooms[x1][y1] > step) {
                            rooms[x1][y1] = step;
                            queue.offer(new int[]{x1, y1});
                        }
                    }
                }
            }
            step++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.wallsAndGates(new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}});
        System.out.println(Integer.MAX_VALUE);
    }
}
