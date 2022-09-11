class Solution {
    public int minGroups(int[][] intervals) {
        int[] count = new int[1000002];
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            count[left]++;
            count[right + 1]--;
        }
        int res = 0;
        int cur = 0;
        for (int i = 1; i < 1000002; i++) {
            cur += count[i];
            res = Math.max(res, cur);
        }
        return res;
    }
}
