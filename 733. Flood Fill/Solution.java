class Solution {
    private int[] dirs = new int[]{0, 1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr >= 0 && sr < image.length && sc >= 0
                && sc < image[0].length && image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                dfs(image, sr + dirs[i], sc + dirs[i + 1], oldColor, newColor);
            }
        }
    }
}
