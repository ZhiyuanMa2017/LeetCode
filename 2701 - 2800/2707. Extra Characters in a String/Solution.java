import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        int minLen = n;
        for (String d : dictionary) {
            set.add(d);
            maxLen = Math.max(maxLen, d.length());
            minLen = Math.min(minLen, d.length());
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + 1;
            int start = Math.max(0, i - maxLen + 1);
            int end = Math.max(0, i - minLen + 1);
            for (int j = start; j <= end; j++) {
                String sub = s.substring(j, i + 1);
                if (set.contains(sub)) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j]);
                }
            }
        }
        return dp[n];
    }
}
