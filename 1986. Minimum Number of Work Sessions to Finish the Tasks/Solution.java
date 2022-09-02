import java.util.Arrays;

class Solution {
    int res;

    public int minSessions(int[] tasks, int sessionTime) {
        res = tasks.length;
        Arrays.sort(tasks);
        reverse(tasks);
        backtrack(tasks, 0, new int[tasks.length], sessionTime, 0);
        return res;
    }

    private void reverse(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public void backtrack(int[] tasks, int idx, int[] taskTime, int sessionTime, int cur) {
        if (cur >= res) {
            return;
        }
        if (idx == tasks.length) {
            res = cur;
            return;
        }
        boolean flag = false;
        for (int i = 0; i < taskTime.length; i++) {
            if (taskTime[i] == 0 && flag) {
                break;
            }
            if (taskTime[i] + tasks[idx] > sessionTime) {
                continue;
            }
            if (taskTime[i] == 0) {
                flag = true;
            }
            taskTime[i] += tasks[idx];
            backtrack(tasks, idx + 1, taskTime, sessionTime, flag ? cur + 1 : cur);
            taskTime[i] -= tasks[idx];
        }
    }
}
