import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] bottomRight = dfs(land, visited, i, j);
                    res.add(new int[]{i, j, bottomRight[0], bottomRight[1]});
                }
            }
        }
        int[][] result = new int[res.size()][4];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private int[] dfs(int[][] land, boolean[][] visited, int i, int j) {
        int x = i;
        int y = j;
        visited[i][j] = true;
        if (i + 1 < land.length && land[i + 1][j] == 1 && !visited[i + 1][j]) {
            int[] cur = dfs(land, visited, i + 1, j);
            x = Math.max(x, cur[0]);
            y = Math.max(y, cur[1]);
        }
        if (j + 1 < land[0].length && land[i][j + 1] == 1 && !visited[i][j + 1]) {
            int[] cur = dfs(land, visited, i, j + 1);
            x = Math.max(x, cur[0]);
            y = Math.max(y, cur[1]);
        }
        return new int[]{x, y};
    }
}
