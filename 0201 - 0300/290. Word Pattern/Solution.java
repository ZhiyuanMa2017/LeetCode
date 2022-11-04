import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternToString = new HashMap<>();
        Map<String, Character> stringToPattern = new HashMap<>();

        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (!patternToString.containsKey(c)) {
                if (stringToPattern.containsKey(word)) {
                    return false;
                }
                patternToString.put(c, word);
                stringToPattern.put(word, c);
            } else {
                if (!patternToString.get(c).equals(word)) {
                    return false;
                }
            }
        }
        return true;
    }
}
