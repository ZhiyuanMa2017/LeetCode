import java.util.Arrays;

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        int len = batteries.length;
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        int i;
        for (i = 0; i < len; i++) {
            int index = len - 1 - i;
            if (batteries[index] > sum / (n - i)) {
                sum -= batteries[index];
            } else {
                break;
            }
        }
        return sum / (n - i);
    }
}
