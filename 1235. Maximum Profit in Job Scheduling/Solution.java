import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a1, a2) -> a1[1] - a2[1]);
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        dpEndTime.add(0);
        dpProfit.add(0);
        for (int[] job : jobs) {
            int sT = job[0];
            int eT = job[1];
            int p = job[2];
            int prev = Collections.binarySearch(dpEndTime, sT + 1);
            if (prev < 0) {
                prev = -prev - 1;
            }
            prev--;
            int curProfit = dpProfit.get(prev) + p;
            int curMaxProfit = dpProfit.get(dpProfit.size() - 1);
            if (curProfit > curMaxProfit) {
                dpProfit.add(curProfit);
                dpEndTime.add(eT);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }
}
