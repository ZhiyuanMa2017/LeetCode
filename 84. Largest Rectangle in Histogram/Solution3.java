import java.util.ArrayDeque;
import java.util.Deque;

class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> s = new ArrayDeque<>();
        s.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (s.peek() != -1 && heights[s.peek()] >= heights[i]) {
                int h = heights[s.pop()];
                int w = i - 1 - s.peek();
                res = Math.max(res, h * w);
            }
            s.push(i);
        }
        while (s.peek() != -1) {
            int h = heights[s.pop()];
            int w = heights.length - 1 - s.peek();
            res = Math.max(res, h * w);
        }
        return res;
    }
}
