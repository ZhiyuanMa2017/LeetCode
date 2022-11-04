class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cur = c - 'a';
            int start = Math.max(cur - k, 0);
            int end = Math.min(cur + k, 25);
            int val = 0;
            for (int j = start; j <= end; j++) {
                val = Math.max(val, dp[j] + 1);
            }
            dp[cur] = val;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
