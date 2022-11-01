class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] bucket = new int[10001];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bucket[mat[i][j]]++;
            }
        }
        for (int i = 1; i < 10001; i++) {
            if (bucket[i] == m) {
                return i;
            }
        }
        return -1;
    }
}
