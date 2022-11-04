import java.util.Arrays;

class Solution20211129 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[] left = new int[m];
        int[] right = new int[m];
        int[] height = new int[m];
        Arrays.fill(right, m - 1);
        for (int i = 0; i < n; i++) {
            int rightBound = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rightBound);
                } else {
                    right[j] = m - 1;
                    rightBound = j - 1;
                }
            }
            int leftBound = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], leftBound);
                    height[j]++;
                    maxArea = Math.max(maxArea, height[j] * (right[j] - left[j] + 1));
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    leftBound = j + 1;
                }
            }
        }
        return maxArea;
    }
}
