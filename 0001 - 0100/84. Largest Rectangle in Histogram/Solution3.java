import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] > heights[i]) {
                right[deque.poll()] = i;
            }
            deque.push(i);
        }
        deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()] > heights[i]) {
                left[deque.poll()] = i;
            }
            deque.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            int l = left[i];
            int r = right[i];
            int w = r - l - 1;
            res = Math.max(res, w * h);
        }
        return res;
    }
}
