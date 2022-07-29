import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean match(String w, String p) {
        int[] ww = new int[26];
        int[] pp = new int[26];
        Arrays.fill(ww, -1);
        Arrays.fill(pp, -1);
        for (int i = 0; i < w.length(); i++) {
            char c1 = w.charAt(i);
            char c2 = p.charAt(i);
            int i1 = c1 - 'a';
            int i2 = c2 - 'a';
            if (ww[i1] == -1) {
                ww[i1] = i2;
            }
            if (pp[i2] == -1) {
                pp[i2] = i1;
            }
            if (ww[i1] != i2) {
                return false;
            }
            if (pp[i2] != i1) {
                return false;
            }
        }
        return true;
    }
}
