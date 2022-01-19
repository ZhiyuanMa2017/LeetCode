class Solution {
    int mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] * count(arr, i) % mod;
            res %= mod;
        }
        return (int) res;
    }

    private long count(int[] arr, int index) {
        int l = index - 1;
        while (l >= 0 && arr[l] > arr[index]) {
            l--;
        }
        int r = index + 1;
        while (r < arr.length && arr[r] >= arr[index]) {
            r++;
        }
        return (long) (index - l) * (r - index) % mod;
    }
}
