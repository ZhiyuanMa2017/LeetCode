class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int h = m * n - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int x = mid / n;
            int y = mid % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return matrix[l / n][l % n] == target;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.searchMatrix(new int[][]{{1, 1}}, 2);
    }
}
