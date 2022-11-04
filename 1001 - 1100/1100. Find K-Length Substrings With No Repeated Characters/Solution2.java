import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        int res = 0;
        Set<Character> window = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            if (right - left + 1 >= k) {
                res++;
            }
        }
        return res;
    }
}
