import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        List<int[]> stack = new ArrayList<>();
        stack.add(new int[]{-1, -1, 0});
        // chosen interval start, end, duration preSum
        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int duration = task[2];
            int l = 0;
            int r = stack.size() - 1;
            // find first interval which interval[0] <= start
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (stack.get(mid)[0] <= start) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int[] interval = stack.get(l);
            // current duration -= pre interval duration preSum
            duration -= stack.get(stack.size() - 1)[2] - interval[2];
            // check if start is in this interval
            if (start <= interval[1]) {
                duration -= interval[1] - start + 1;
            }

            if (duration <= 0) {
                continue;
            }
            // remove intervals and combine them
            while (end - stack.get(stack.size() - 1)[1] <= duration) {
                interval = stack.remove(stack.size() - 1);
                duration += interval[1] - interval[0] + 1;
            }
            // add this new interval
            stack.add(new int[]{end - duration + 1, end, stack.get(stack.size() - 1)[2] + duration});
        }
        return stack.get(stack.size() - 1)[2];
    }
}
