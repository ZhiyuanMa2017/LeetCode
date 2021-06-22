import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        List<StringBuilder>[] waiting = new List[26];
        for (int i = 0; i < 26; i++) {
            waiting[i] = new ArrayList<>();
        }
        for (String w : words) {
            waiting[w.charAt(0) - 'a'].add(new StringBuilder(w));
        }
        // waiting: words start with this character

        for (char c : s.toCharArray()) {
            List<StringBuilder> thisC = waiting[c - 'a'];
            waiting[c - 'a'] = new ArrayList<>();
            // get all words starting with this character and delete this character
            // if one word deletes all characters, res will plus one
            // else, put the remaining word back to the waiting array
            for (StringBuilder stringBuilder : thisC) {
                stringBuilder.deleteCharAt(0);
                if (stringBuilder.length() != 0) {
                    waiting[stringBuilder.charAt(0) - 'a'].add(stringBuilder);
                } else {
                    res++;
                }
            }
        }
        return res;
    }
}
