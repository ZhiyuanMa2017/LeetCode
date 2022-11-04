class Solution {
    int[] memo;

    public int deleteString(String s) {
        memo = new int[s.length()];
        return dfs(s, 0);
    }

    private int dfs(String s, int begin) {
        if (s.length() == 1) {
            return 1;
        }
        if (memo[begin] > 0) {
            return memo[begin];
        }
        int curLen = s.length() - begin;
        int res = 0;
        for (int len = 1; len <= curLen / 2; len++) {
            int secondStart = begin + len;
            boolean match = true;
            for (int i = begin; i < secondStart; i++) {
                if (s.charAt(i) != s.charAt(i + len)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                res = Math.max(res, dfs(s, secondStart));
            }
            if (res + 1 == s.length() - begin) {
                break;
            }
        }
        memo[begin] = res + 1;
        return res + 1;
    }
}
