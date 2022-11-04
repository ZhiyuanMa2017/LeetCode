class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int curMin = 0, windowSize = cardPoints.length - k, total = 0, minMin;
        for (int i = 0; i < windowSize; i++) {
            curMin += cardPoints[i];
        }
        minMin = curMin;
        total = curMin;
        for (int i = windowSize; i < cardPoints.length; i++) {
            curMin += cardPoints[i];
            curMin -= cardPoints[i - windowSize];
            total += cardPoints[i];
            minMin = Math.min(curMin, minMin);
        }
        return total - minMin;
    }
}
