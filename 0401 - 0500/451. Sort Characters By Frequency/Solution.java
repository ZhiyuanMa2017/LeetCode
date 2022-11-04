import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(i)));
        }
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i < maxFreq + 1; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Character c : map.keySet()) {
            buckets.get(map.get(c)).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            for (Character c : buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
