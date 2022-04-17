import java.util.Arrays;

class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = 0;
        int i = 0;
        while (i < tasks.length) {
            int j = i;
            while (i < tasks.length && tasks[j] == tasks[i]) {
                i++;
            }
            if (i - j == 1) {
                return -1;
            }
            res += (i - j + 2) / 3;
        }
        return res;
    }
}
