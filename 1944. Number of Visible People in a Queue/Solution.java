import java.util.Stack;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[i] > heights[s.peek()]) {
                s.pop();
                res[i]++;
            }
            if (!s.isEmpty()) {
                res[i]++;
            }
            s.push(i);
        }
        return res;
    }
}
