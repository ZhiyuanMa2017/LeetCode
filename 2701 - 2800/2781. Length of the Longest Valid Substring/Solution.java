import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length();
        Set<String> fb = new HashSet<>(forbidden);
        int res = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            for (int i = right; i >= left && i > right - 10; i--) {
                if (fb.contains(word.substring(i, right + 1))) {
                    left = i + 1;
                    break;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
