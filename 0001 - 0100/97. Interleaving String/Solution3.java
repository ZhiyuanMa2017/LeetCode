class Solution {
    char[] c1;
    char[] c2;
    char[] c3;
    int[][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        cache = new int[l1 + 1][l2 + 1];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j] == 1;
        }
        if (i + j == c3.length) {
            return true;
        }
        boolean res = false;
        if (i < c1.length && c1[i] == c3[i + j]) {
            res |= dfs(i + 1, j);
        }
        if (j < c2.length && c2[j] == c3[i + j]) {
            res |= dfs(i, j + 1);
        }
        cache[i][j] = res ? 1 : -1;
        return res;
    }
}
