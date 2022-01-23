import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int lower = pricing[0];
        int higher = pricing[1];
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                if (o1[3] != o2[3]) {
                    return o1[3] - o2[3];
                }
                return 0;
            }
        });
        Queue<int[]> queue = new LinkedList<>();
        int x = start[0];
        int y = start[1];
        queue.add(start);
        visited[x][y] = true;
        int dis = 0;
        while (!queue.isEmpty()) {
            if (pq.size() >= k) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                x = cur[0];
                y = cur[1];
                if (grid[x][y] >= lower && grid[x][y] <= higher) {
                    pq.add(new int[]{dis, grid[x][y], x, y});
                }
                for (int j = 0; j < 4; j++) {
                    int newX = x + dirs[j];
                    int newY = y + dirs[j + 1];
                    if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                        continue;
                    }
                    if (grid[newX][newY] == 0) {
                        continue;
                    }
                    if (visited[newX][newY]) {
                        continue;
                    }
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            dis++;
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            k--;
            List<Integer> l = new ArrayList<>();
            l.add(cur[2]);
            l.add(cur[3]);
            res.add(l);
        }
        return res;
    }
}
