import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int total = map.size();
        int formed = 0;
        int l = 0;
        int r = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLength = s.length() + 1;
        Map<Character, Integer> window = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (map.containsKey(c) && map.get(c).equals(window.get(c))) {
                formed++;
            }
            while (l <= r && formed == total) {
                char cl = s.charAt(l);
                if (r - l + 1 < minLength) {
                    minLeft = l;
                    minRight = r;
                    minLength = r - l + 1;
                }
                window.put(cl, window.get(cl) - 1);
                l++;
                if (map.containsKey(cl) && map.get(cl).compareTo(window.get(cl)) > 0) {
                    formed--;
                }
            }
            r++;
        }
        return minLength == s.length() + 1 ? "" : s.substring(minLeft, minRight + 1);
    }
}
