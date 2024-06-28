import java.util.Arrays;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] count = new int[n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
        }
        Arrays.sort(count);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) (i + 1) * count[i];
        }
        return res;
    }
}
