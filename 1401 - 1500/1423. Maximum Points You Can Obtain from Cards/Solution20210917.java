class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += cardPoints[i];
        }
        int res = curSum;
        int n = cardPoints.length;
        for (int i = k - 1; i >= 0; i--) {
            int index = n - (k - i);
            curSum += cardPoints[index] - cardPoints[i];
            res = Math.max(res, curSum);
        }
        return res;
    }
}
