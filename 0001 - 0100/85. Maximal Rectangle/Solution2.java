import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
                res = Math.max(res, largestRectangleArea(heights));
            }
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // increasing stack
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int h = heights[stack.pop()];
                int w = i - 1 - stack.peek();
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = heights.length - 1 - stack.peek();
            res = Math.max(res, h * w);
        }
        return res;
    }
}
