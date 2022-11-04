import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] thisCell = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = thisCell[0] + dirs[i];
                int y = thisCell[1] + dirs[i + 1];
                if (x >= 0 && y >= 0 && x < m && y < n
                        && mat[x][y] > mat[thisCell[0]][thisCell[1]] + 1) {
                    mat[x][y] = mat[thisCell[0]][thisCell[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return mat;
    }
}
