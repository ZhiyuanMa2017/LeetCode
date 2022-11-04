class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int res = preSum[firstLen + secondLen - 1];
        int fMax = preSum[firstLen - 1];
        int sMax = preSum[secondLen - 1];
        for (int end = firstLen + secondLen; end < n; end++) {
            fMax = Math.max(fMax, preSum[end - secondLen] - preSum[end - secondLen - firstLen]);
            sMax = Math.max(sMax, preSum[end - firstLen] - preSum[end - firstLen - secondLen]);
            int fs = fMax + preSum[end] - preSum[end - secondLen];
            int sf = sMax + preSum[end] - preSum[end - firstLen];
            res = Math.max(res, Math.max(fs, sf));
        }
        return res;
    }
}
