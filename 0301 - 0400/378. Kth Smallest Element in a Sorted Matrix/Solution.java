class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        int l = matrix[0][0];
        int h = matrix[r - 1][c - 1];
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int i1 = 0; i1 < c; i1++) {
                    if (matrix[i][i1] <= mid) {
                        count++;
                    }
                }
            }
            if (count < k) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }
}
