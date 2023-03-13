import java.util.Arrays;

class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        boolean[] used = new boolean[2001];
        int res = 0;
        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int duration = task[2];
            int have = 0;
            for (int i = start; i <= end; i++) {
                if (used[i]) {
                    have++;
                }
            }
            if (have >= duration) {
                continue;
            }
            int remain = duration - have;
            for (int i = end; i >= start; i--) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                remain--;
                res++;
                if (remain == 0) {
                    break;
                }
            }
        }
        return res;
    }
}
