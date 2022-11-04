import java.util.HashSet;
import java.util.Set;

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        for (String word : startWords) {
            int hash = 0;
            for (int i = 0; i < word.length(); i++) {
                hash |= 1 << (word.charAt(i) - 'a');
            }
            set.add(hash);
        }

        int res = 0;
        for (String word : targetWords) {
            int hash = 0;
            for (int i = 0; i < word.length(); i++) {
                hash |= 1 << (word.charAt(i) - 'a');
            }
            for (int i = 0; i < 26; i++) {
                if ((hash & 1 << i) != 0 && set.contains(hash ^ (1 << i))) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
