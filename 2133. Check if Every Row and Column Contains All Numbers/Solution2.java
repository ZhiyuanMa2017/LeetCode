class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int xor1 = 0;
            int xor2 = 0;
            for (int j = 0; j < n; j++) {
                xor1 ^= (j + 1) ^ matrix[i][j];
                xor2 ^= (j + 1) ^ matrix[j][i];
            }
            if (xor1 != 0 || xor2 != 0) {
                return false;
            }
        }
        return true;
    }
}
