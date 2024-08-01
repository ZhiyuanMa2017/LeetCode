import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(s, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(String s, int length) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + length > s.length()) {
                break;
            }
            String cur = s.substring(i, i + length);
            if (set.contains(cur)) {
                return true;
            } else {
                set.add(cur);
            }
        }
        return false;
    }
}
