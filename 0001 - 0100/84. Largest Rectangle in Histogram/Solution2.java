class Solution2 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] lessleft = new int[heights.length];
        int[] lessright = new int[heights.length];
        lessleft[0] = -1;
        lessright[heights.length - 1] = heights.length;
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessleft[p];
            }
            lessleft[i] = p;
        }
        for (int i = heights.length - 2; i > -1; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessright[p];
            }
            lessright[i] = p;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (lessright[i] - lessleft[i] - 1));
        }
        return res;
    }
}
