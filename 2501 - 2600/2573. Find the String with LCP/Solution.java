class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) {
                return "";
            }
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) {
                    return "";
                }
                if (lcp[i][j] > n - Math.max(i, j)) {
                    return "";
                }
            }
        }
        int[] ss = new int[n];
        int cur = 1;
        for (int i = 0; i < n; i++) {
            if (ss[i] == 0) {
                if (cur > 26) {
                    return "";
                }
                ss[i] = cur;
                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        ss[j] = cur;
                    }
                }
                cur++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (ss[i] == ss[j]) {
                    if (i == n - 1 || j == n - 1) {
                        if (lcp[i][j] != 1) {
                            return "";
                        }
                    } else if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
                        return "";
                    }
                } else if (lcp[i][j] != 0) {
                    return "";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) ('a' + ss[i] - 1));
        }
        return sb.toString();
    }
}
