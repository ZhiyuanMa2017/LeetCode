import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> similarPair : similarPairs) {
            String str1 = similarPair.get(0);
            String str2 = similarPair.get(1);
            if (!map.containsKey(str1)) {
                map.put(str1, new HashSet<>());
            }
            if (!map.containsKey(str2)) {
                map.put(str2, new HashSet<>());
            }
            map.get(str1).add(str2);
            map.get(str2).add(str1);
        }
        for (int i = 0; i < sentence1.length; i++) {
            String str1 = sentence1[i];
            String str2 = sentence2[i];
            if (str1.equals(str2)) {
                continue;
            }
            if (map.containsKey(str1) && map.get(str1).contains(str2)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
