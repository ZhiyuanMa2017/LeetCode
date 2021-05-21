import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> mapWtoP = new HashMap<>();
        Map<Character, Character> mapPtoW = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character w = word.charAt(i);
            Character p = pattern.charAt(i);
            mapWtoP.putIfAbsent(w, p);
            mapPtoW.putIfAbsent(p, w);
            if (p != mapWtoP.get(w) || w != mapPtoW.get(p)) {
                return false;
            }
        }
        return true;
    }
}
