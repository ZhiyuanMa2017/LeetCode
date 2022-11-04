import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        int mod = 1000000007;
        Map<Integer, Integer> numToIndex = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            numToIndex.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && numToIndex.containsKey(arr[i] / arr[j])) {
                    dp[i] = (dp[i] + dp[j] * dp[numToIndex.get(arr[i] / arr[j])] % mod) % mod;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + dp[i]) % mod;
        }
        return (int) res;
    }
}
