class Solution {

    public int threeSumMulti(int[] arr, int target) {
        int[] count = new int[101];
        long res = 0;
        for (int i : arr) {
            count[i]++;
        }
        int mod = 1000000007;
        for (int i = 0; i < 101; i++) {
            for (int j = i; j < 101; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) {
                    continue;
                }
                if (i == j && j == k) {
                    res = (res + (long) count[i] * (count[i] - 1) * (count[i] - 2) / 6) % mod;
                } else if (i == j && j != k) {
                    res = (res + (long) count[i] * (count[i] - 1) / 2 * count[k]) % mod;
                } else if (j < k) {
                    res = (res + (long) count[i] * count[j] * count[k]) % mod;
                }
            }
        }
        return (int) res;
    }
}
