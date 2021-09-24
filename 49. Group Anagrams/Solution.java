import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = new char[26];
            for (char c : s.toCharArray()) {
                chars[c - 'a']++;
            }
            String thisS = String.valueOf(chars);
            if (!map.containsKey(thisS)) {
                map.put(thisS, new ArrayList<>());
            }
            map.get(thisS).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
