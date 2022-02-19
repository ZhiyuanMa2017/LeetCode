import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < k; i++) {
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (window.size() == k) {
            res++;
        }
        for (int i = k; i + k - 1 < s.length(); i++) {
            char left = s.charAt(i - 1);
            window.put(left, window.get(left) - 1);
            if (window.get(left) == 0) {
                window.remove(left);
            }
            char right = s.charAt(i + k - 1);
            window.put(right, window.getOrDefault(right, 0) + 1);
            if (window.size() == k) {
                res++;
            }
        }
        return res;
    }
}
