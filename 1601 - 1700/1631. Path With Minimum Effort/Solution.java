import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int[][] effort = new int[r][c];
        for (int i = 0; i < effort.length; i++) {
            for (int j = 0; j < effort[i].length; j++) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        priorityQueue.add(new int[]{0, 0, 0});
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!priorityQueue.isEmpty()) {
            int[] mineffort = priorityQueue.poll();
            int x = mineffort[0];
            int y = mineffort[1];
            int e = mineffort[2];
            if (x == r - 1 && y == c - 1) {
                return e;
            }
            for (int[] d : dir) {
                int newx = x + d[0];
                int newy = y + d[1];
                if (newx < 0 || newx >= r || newy < 0 || newy >= c) {
                    continue;
                }
                int thiseffort = Math.max(e, Math.abs(heights[x][y] - heights[newx][newy]));
                if (effort[newx][newy] > thiseffort) {
                    effort[newx][newy] = thiseffort;
                    priorityQueue.add(new int[]{newx, newy, thiseffort});
                }
            }

        }
        return 0;
    }
}
