class Solution2 {

// greedy solution with idea of DFS
// starj stores the position of last * in p
// last_match stores the position of the previous matched char in s after a *
// e.g.
// s: a c d s c d
// p: * c d
// after the first match of the *, starj = 0 and last_match = 1
// when we come to i = 3 and j = 3, we know that the previous match of * is actually wrong,
// (the first branch of DFS we take is wrong)
// then it resets j = starj + 1
// since we already know i = last_match will give us the wrong answer
// so this time i = last_match+1 and we try to find a longer match of *
// then after another match we have starj = 0 and last_match = 4, which is the right solution
// since we don't know where the right match for * ends,
// we need to take a guess (one branch in DFS), and store the information(starj and last_match)
// so we can always backup to the last correct place and take another guess.
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int lastMatch = -1;
        int starIndex = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                lastMatch = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                lastMatch++;
                i = lastMatch;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}
