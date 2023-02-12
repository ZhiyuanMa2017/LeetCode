import java.util.Arrays;

class Solution {
    public int minimumScore(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] pre = new int[m];
        Arrays.fill(pre, -1);
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                pre[j] = i;
                j++;
            }
            if (j == m) {
                return 0;
            }
        }
        j--;
        int res = m - 1 - j;
        int k = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(k)) {
                while (j >= 0 && pre[j] >= i) {
                    j--;
                }
                res = Math.min(res, k - j - 1);
                k--;
            }
        }
        return res;
    }
}
