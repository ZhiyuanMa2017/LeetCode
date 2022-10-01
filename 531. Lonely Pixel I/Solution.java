class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (rowCount[i] > 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (colCount[j] > 1) {
                    continue;
                }
                if (picture[i][j] == 'B') {
                    res++;
                }
            }
        }
        return res;
    }
}
