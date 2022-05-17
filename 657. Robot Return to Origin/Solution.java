class Solution {
    public boolean judgeCircle(String moves) {
        if (moves.length() % 2 != 0) {
            return false;
        }
        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                u++;
            } else if (moves.charAt(i) == 'D') {
                d++;
            } else if (moves.charAt(i) == 'L') {
                l++;
            } else {
                r++;
            }
        }
        return u == d && l == r;
    }
}
