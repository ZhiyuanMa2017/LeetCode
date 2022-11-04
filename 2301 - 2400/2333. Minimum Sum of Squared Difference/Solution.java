class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int k = k1 + k2;
        int[] bucket = new int[100001];
        long sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            bucket[diff]++;
            sum += diff;
        }
        if (sum <= k) {
            return 0;
        }
        for (int i = 100000; i > 0; i--) {
            if (k == 0) {
                break;
            }
            if (bucket[i] > 0) {
                int val = Math.min(bucket[i], k);
                bucket[i] -= val;
                bucket[i - 1] += val;
                k -= val;
            }
        }
        long res = 0;
        for (int i = 0; i < 100001; i++) {
            res += (long) bucket[i] * i * i;
        }
        return res;
    }
}
