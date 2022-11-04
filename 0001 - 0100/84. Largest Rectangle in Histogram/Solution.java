class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = 1;
            for (int j = Math.max(0, i - 1); j > -1; j--) {
                if (j != i) {
                    if (heights[j] < heights[i]) {
                        break;
                    } else {
                        width++;
                    }
                }
            }
            for (int k = Math.min(i + 1, heights.length - 1); k < heights.length; k++) {
                if (k != i) {
                    if (heights[k] < heights[i]) {
                        break;
                    } else {
                        width++;
                    }
                }
            }
            res = Math.max(res, width * heights[i]);
        }
        return res;
    }
}
