import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String w : map.keySet()) {
            if (isSubseq(s, w)) {
                res += map.get(w);
            }
        }
        return res;
    }

    private boolean isSubseq(String s, String w) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = w.length();
        while (i < n && j < m) {
            if (s.charAt(i) == w.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == w.length();
    }
}
