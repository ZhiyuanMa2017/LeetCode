import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[621][621];
        visited[310][310] = true;
        int level = 0;
        int[][] dirs = new int[][]{{-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}, {1, 2}, {2, 1}, {1, -2}, {2, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == x && cur[1] == y) {
                    return level;
                }
                for (int j = 0; j < dirs.length; j++) {
                    int newX = cur[0] + dirs[j][0];
                    int newY = cur[1] + dirs[j][1];
                    if (!visited[newX + 310][newY + 310]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX + 310][newY + 310] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
