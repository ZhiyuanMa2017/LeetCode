class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int rollSum = 0;
        for (int roll : rolls) {
            rollSum += roll;
        }
        int nSum = (n + rolls.length) * mean - rollSum;
        if (nSum < n || nSum > 6 * n) {
            return new int[0];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nSum / n;
        }
        for (int i = 0; i < nSum % n; i++) {
            res[i] += 1;
        }
        return res;
    }
}
