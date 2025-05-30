import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        Deque<Integer> decreasing = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!decreasing.isEmpty() && nums[decreasing.peekLast()] <= nums[i]) {
                int last = decreasing.pollLast();
                graph[last].add(i);
            }
            decreasing.addLast(i);
        }
        Deque<Integer> increasing = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!increasing.isEmpty() && nums[increasing.peekLast()] > nums[i]) {
                int last = increasing.pollLast();
                graph[last].add(i);
            }
            increasing.addLast(i);
        }
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (Integer next : graph[i]) {
                dp[next] = Math.min(dp[next], dp[i] + costs[next]);
            }
        }
        return dp[n - 1];
    }
}
