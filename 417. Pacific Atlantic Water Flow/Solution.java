import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int[] dirs = new int[]{-1, 0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            pq.add(new int[]{i, 0});
            aq.add(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pq.add(new int[]{0, j});
            aq.add(new int[]{m - 1, j});
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }
        bfs(heights, pacific, pq);
        bfs(heights, atlantic, aq);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>(List.of(i, j));
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int m = heights.length;
        int n = heights[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dirs[i];
                int y = cur[1] + dirs[i + 1];
                if (x >= 0 && x < m && y >= 0 && y < n
                        && !visited[x][y] && heights[x][y] >= heights[cur[0]][cur[1]]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
