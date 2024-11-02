class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int[][] count = new int[n][26];
        count[0][s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            count[i][s.charAt(i) - 'a'] = 1;
            for (int j = 0; j < 26; j++) {
                count[i][j] += count[i - 1][j];
            }
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            for (int j = 0; j < 26; j++) {
                int cnt = count[r][j];
                if (l > 0) {
                    cnt -= count[l - 1][j];
                }
                res[i] += cnt * (cnt + 1) / 2;
            }
        }
        return res;
    }
}
