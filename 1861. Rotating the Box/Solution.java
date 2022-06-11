class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = box[m - 1 - j][i];
            }
        }
        for (int j = 0; j < m; j++) {
            int position = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (res[i][j] == '*') {
                    position = i - 1;
                } else if (res[i][j] == '#') {
                    res[i][j] = '.';
                    res[position][j] = '#';
                    position--;
                }
            }
        }
        return res;
    }
}
