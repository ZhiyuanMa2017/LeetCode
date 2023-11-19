import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        List<List<int[]>> toAnswer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            toAnswer.add(new ArrayList<>());
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int smallIndex = queries[i][0];
            int largeIndex = queries[i][1];
            if (smallIndex > largeIndex) {
                int temp = smallIndex;
                smallIndex = largeIndex;
                largeIndex = temp;
            }
            if (smallIndex == largeIndex || heights[smallIndex] < heights[largeIndex]) {
                ans[i] = largeIndex;
            } else {
                toAnswer.get(largeIndex).add(new int[]{i, heights[smallIndex]});
            }
        }
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        for (int i = n - 1; i >= 0; i--) {
            while (stack.peek()[1] <= heights[i]) {
                stack.pop();
            }
            for (int[] pair : toAnswer.get(i)) {
                int index = pair[0];
                int value = pair[1];
                int l = 0;
                int r = stack.size() - 1;
                while (l < r) {
                    int mid = l + (r - l + 1) / 2;
                    if (stack.get(mid)[1] <= value) {
                        r = mid - 1;
                    } else {
                        l = mid;
                    }
                }
                ans[index] = stack.get(l)[0];
            }
            stack.push(new int[]{i, heights[i]});
        }
        return ans;
    }
}
