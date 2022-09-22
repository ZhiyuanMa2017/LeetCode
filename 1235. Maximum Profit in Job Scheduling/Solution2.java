import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> jobs = new ArrayList<>();
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            int[] job = new int[]{startTime[i], endTime[i], profit[i]};
            jobs.add(job);
        }
        Collections.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int res = 0;
        for (int[] job : jobs) {
            int start = job[0];
            int end = job[1];
            int p = job[2];
            Integer key = treeMap.floorKey(start);
            if (key != null) {
                p += treeMap.get(key);
            }
            if (p > res) {
                treeMap.put(end, p);
                res = p;
            }
        }
        return res;
    }
}
