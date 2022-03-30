import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0;
        int h = tokens.length - 1;
        int score = 0;
        int res = 0;
        while (l <= h) {
            if (power >= tokens[l]) {
                power -= tokens[l];
                score++;
                l++;
                res = Math.max(res, score);
            } else {
                if (score > 0) {
                    score--;
                    power += tokens[h];
                    h--;
                } else {
                    break;
                }
            }

        }
        return res;
    }
}
