import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> stringSet = new HashSet<>();

        return backtrack(pattern, 0, s, 0, map, stringSet);
    }

    private boolean backtrack(String pattern, int i, String s, int j,
                              Map<Character, String> map, Set<String> stringSet) {
        if (i == pattern.length() && j == s.length()) {
            return true;
        }
        if (i == pattern.length() || j == s.length()) {
            return false;
        }
        if (map.containsKey(pattern.charAt(i))) {
            String word = map.get(pattern.charAt(i));
            if (!s.startsWith(word, j)) {
                return false;
            }
            return backtrack(pattern, i + 1, s, j + word.length(), map, stringSet);
        }
        for (int k = j; k < s.length(); k++) {
            String nextWord = s.substring(j, k + 1);
            if (stringSet.contains(nextWord)) {
                continue;
            }
            stringSet.add(nextWord);
            map.put(pattern.charAt(i), nextWord);
            if (backtrack(pattern, i + 1, s, j + nextWord.length(), map, stringSet)) {
                return true;
            }
            stringSet.remove(nextWord);
            map.remove(pattern.charAt(i));
        }
        return false;
    }
}
