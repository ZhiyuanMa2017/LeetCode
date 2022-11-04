class Solution {
    public int numRookCaptures(char[][] board) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x;
            int yy = y;
            while (xx >= 0 && xx < 8 && yy >= 0 && yy < 8) {
                if (board[xx][yy] == 'B') {
                    break;
                }
                if (board[xx][yy] == 'p') {
                    res++;
                    break;
                }
                xx += dirs[i];
                yy += dirs[i + 1];
            }
        }
        return res;
    }
}
