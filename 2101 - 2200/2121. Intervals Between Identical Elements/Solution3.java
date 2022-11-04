class Solution3 {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        int[] rCount = new int[100005];
        long[] rSum = new long[100005];
        for (int i = 0; i < n; i++) {
            rCount[arr[i]]++;
            rSum[arr[i]] += i;
        }
        int[] lCount = new int[100005];
        long[] lSum = new long[100005];
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long leftSum = (long) lCount[arr[i]] * i - lSum[arr[i]];
            long rightSum = rSum[arr[i]] - (long) rCount[arr[i]] * i;
            res[i] = leftSum + rightSum;
            lCount[arr[i]]++;
            lSum[arr[i]] += i;
            rCount[arr[i]]--;
            rSum[arr[i]] -= i;
        }
        return res;
    }
}
