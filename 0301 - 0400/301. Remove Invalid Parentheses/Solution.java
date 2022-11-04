import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void dfs(String s, List<String> res, int last_i, int last_j, char[] brackets) {
        int score = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == brackets[0]) {
                score++;
            }
            if (s.charAt(i) == brackets[1]) {
                score--;
            }
            if (score >= 0) {
                continue;
            }
            // score < 0 means we need to remove pair[1]
            // begin at last_j, cause before last_j the prefix is valid
            for (int j = last_j; j <= i; j++) {
                // try every option to remove to make the prefix valid
                // only remove the first bracket when there are consecutive ones
                if (s.charAt(j) == brackets[1] && (j == 0 || s.charAt(j - 1) != brackets[1])) {
                    dfs(s.substring(0, j) + s.substring(j + 1), res, i, j, brackets);
                }
            }
            // only deal with the first bracket which makes the prefix invalid
            // the left will be dealt with the recursion
            // to do so, there will not be duplicates
            return;
        }
        // valid for one kind of bracket, so not go into the loop
        // reverse the string to be ready to check the other kind of bracket
        String reversed = new StringBuilder(s).reverse().toString();
        if (brackets[0] == '(') {
            // finished left to right
            dfs(reversed, res, 0, 0, new char[]{')', '('});
        } else {
            // finished right to left
            // we finished, and pair[0] == ')', so here we are in the reversed REMOVE,
            // and the reversed string is reversed
            // we just add reversed, which is what we need
            res.add(reversed);
        }
    }
}
