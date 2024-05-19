class Solution {
    public int numberOfCleanRooms(int[][] room) {
        int m = room.length;
        int n = room[0].length;
        boolean[][][] visited = new boolean[m][n][4];
        boolean[][] cleaned = new boolean[m][n];
        int direction = 0;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int res = 1;
        cleaned[0][0] = true;
        int x = 0;
        int y = 0;
        while (!visited[x][y][direction]) {
            visited[x][y][direction] = true;
            int a = x + dirs[direction];
            int b = y + dirs[direction + 1];
            if (a < 0 || b < 0 || a >= m || b >= n) {
                direction = (direction + 1) % 4;
            } else {
                if (room[a][b] == 1) {
                    direction = (direction + 1) % 4;
                } else {
                    x = a;
                    y = b;
                    if (!cleaned[x][y]) {
                        res++;
                        cleaned[x][y] = true;
                    }
                }
            }
        }
        return res;
    }
}
