class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] t = new int[60];
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            t[time[i] % 60] += 1;
        }
        res += t[0] * (t[0] - 1) / 2;
        res += t[30] * (t[30] - 1) / 2;
        for (int j = 1; j < 30; j++) {
            res += t[j] * t[60 - j];
        }
        return res;
    }
}
