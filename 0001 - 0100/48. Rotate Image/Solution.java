class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
//      clockwise
//      reverse up to down, then swap the symmetry first
//      1 2 3     7 8 9     7 4 1
//      4 5 6  => 4 5 6  => 8 5 2
//      7 8 9     1 2 3     9 6 3
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = tmp;
        }
//        7 8 9     7 4 1
//        4 5 6  => 8 5 2
//        1 2 3     9 6 3
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
//      anti-clockwise,
//      swap the symmetry first, then reverse up to down
//      1 2 3     1 4 7     3 6 9
//      4 5 6  => 2 5 8  => 2 5 8
//      7 8 9     3 6 9     1 4 7
    }
}
