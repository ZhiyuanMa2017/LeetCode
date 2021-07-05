class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] reshape = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int i1 = 0; i1 < c; i1++) {
                reshape[i][i1] = nums[index / n][index % n];
                index++;
            }
        }
        return reshape;
    }
}
