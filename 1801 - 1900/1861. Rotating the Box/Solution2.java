class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            int open = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][open] = '#';
                    res[open][m - i - 1] = box[i][open];
                    open--;
                } else if (box[i][j] == '*') {
                    open = j - 1;
                }
                res[j][m - i - 1] = box[i][j];
            }
        }
        return res;
    }
}
