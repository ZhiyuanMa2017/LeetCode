class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;
        for (int[] row : A) {
            for (int i = 0; i * 2 < len; i++) {
                if (row[i] == row[len - i - 1]) {
                    row[i] = row[i] ^ 1;
                    row[len - i - 1] = row[i];
                }
            }
        }
        return A;
    }
    /*
    *https://leetcode.com/problems/flipping-an-image/discuss/130590/C%2B%2BJavaPython-Reverse-and-Toggle
    */
}