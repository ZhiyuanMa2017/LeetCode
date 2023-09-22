import java.util.Arrays;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        int n = t.length();
        int[][] next = new int[n][26];
        int[] cur = new int[26];
        Arrays.fill(cur, -1);
        for (int i = t.length() - 1; i >= 0; i--) {
            char c = t.charAt(i);
            System.arraycopy(cur, 0, next[i], 0, 26);
            cur[c - 'a'] = i;
        }
        int index = -1;
        if (s.charAt(0) == t.charAt(0)) {
            index = 0;
        } else {
            index = next[0][s.charAt(0) - 'a'];
        }
        for (int i = 1; i < s.length(); i++) {
            if (index == -1) {
                break;
            }
            char c = s.charAt(i);
            index = next[index][c - 'a'];
        }
        return index != -1;
    }
}
