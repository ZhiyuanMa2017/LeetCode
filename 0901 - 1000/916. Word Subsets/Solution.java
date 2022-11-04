import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] maxcountinb = new int[26];
        for (String b : B) {
            int[] tmp = counter(b);
            for (int i = 0; i < 26; i++) {
                maxcountinb[i] = Math.max(tmp[i], maxcountinb[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (String a : A) {
            int[] atmp = counter(a);
            int i;
            for (i = 0; i < 26; i++) {
                if (atmp[i] < maxcountinb[i]) {
                    break;
                }
            }
            if (i == 26) {
                res.add(a);
            }
        }
        return res;
    }

    private int[] counter(String word) {
        int[] counts = new int[26];
        for (char c : word.toCharArray()) {
            counts[c - 'a']++;
        }
        return counts;
    }
}
