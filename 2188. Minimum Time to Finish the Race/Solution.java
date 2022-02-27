import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        List<Integer> countPerLaps = new ArrayList<>();
        countPerLaps.add(Integer.MAX_VALUE);
        for (int[] tire : tires) {
            long f = tire[0];
            long cur = 0;
            for (int i = 1; i < 17; i++) {
                cur += f;
                if (cur > Integer.MAX_VALUE) {
                    break;
                }
                if (countPerLaps.size() <= i) {
                    countPerLaps.add((int) cur);
                } else if (countPerLaps.get(i) > cur) {
                    countPerLaps.set(i, (int) cur);
                }
                f *= tire[1];
            }
        }
        int[] dp = new int[numLaps + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int size = countPerLaps.size();
        for (int i = 1; i < numLaps + 1; i++) {
            for (int j = 1; j <= i && j < size; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + changeTime + countPerLaps.get(j));
            }
        }
        return dp[numLaps] - changeTime;
    }
}
