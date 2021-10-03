class Solution {
    public int minimumMoves(String s) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                res += 1;
                i += 3;
            } else {
                i += 1;
            }
        }
        return res;
    }
}
