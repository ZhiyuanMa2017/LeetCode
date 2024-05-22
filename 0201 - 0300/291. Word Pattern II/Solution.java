import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return backtrack(pattern, 0, s, 0, map, set);
    }

    private boolean backtrack(String pattern, int index, String s, int index2, Map<Character, String> map, Set<String> set) {
        if (index == pattern.length() && index2 == s.length()) {
            return true;
        } else if (index == pattern.length() || index2 == s.length()) {
            return false;
        }
        char c = pattern.charAt(index);
        if (map.containsKey(c)) {
            String sub = map.get(c);
            if (!s.startsWith(sub, index2)) {
                return false;
            } else {
                return backtrack(pattern, index + 1, s, index2 + sub.length(), map, set);
            }
        } else {
            for (int i = index2; i < s.length(); i++) {
                String sub = s.substring(index2, i + 1);
                if (set.contains(sub)) {
                    continue;
                }
                map.put(c, sub);
                set.add(sub);
                if (backtrack(pattern, index + 1, s, i + 1, map, set)) {
                    return true;
                }
                map.remove(c);
                set.remove(sub);
            }
        }
        return false;
    }
}
