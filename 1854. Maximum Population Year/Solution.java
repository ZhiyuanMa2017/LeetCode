class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] year = new int[101];
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            year[birth - 1950]++;
            year[death - 1950]--;
        }
        int res = 0;
        int cur = 0;
        int max = 0;
        for (int i = 0; i < 101; i++) {
            cur += year[i];
            if (cur > max) {
                max = cur;
                res = i;
            }
        }
        return res + 1950;
    }
}
