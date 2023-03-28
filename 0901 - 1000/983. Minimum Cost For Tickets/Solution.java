import java.util.TreeMap;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            treeMap.put(days[i], i);
        }
        treeMap.put(-30, -1);
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int one = dp[i] + costs[0];
            Integer key7 = treeMap.floorKey(days[i] - 7);
            int seven = dp[treeMap.get(key7) + 1] + costs[1];
            Integer key30 = treeMap.floorKey(days[i] - 30);
            int thirty = dp[treeMap.get(key30) + 1] + costs[2];
            dp[i + 1] = Math.min(one, Math.min(seven, thirty));
        }
        return dp[n];
    }
}
