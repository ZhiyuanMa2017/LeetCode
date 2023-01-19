import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26];
        int res = -1;
        Arrays.fill(first, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] != -1) {
                res = Math.max(res, i - first[c] - 1);
            } else {
                first[c] = i;
            }
        }
        return res;
    }
}
