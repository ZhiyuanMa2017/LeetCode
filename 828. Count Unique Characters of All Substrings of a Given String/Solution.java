import java.util.Arrays;

class Solution {
    public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(index[i], -1);
        }
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int character = s.charAt(i) - 'A';
            int previous = index[character][1];
            int before = index[character][0];
            res += (i - previous) * (previous - before);
            index[character] = new int[]{previous, i};
        }
        for (int i = 0; i < 26; i++) {
            res += (index[i][1] - index[i][0]) * (n - index[i][1]);
        }
        return res;
    }
}
