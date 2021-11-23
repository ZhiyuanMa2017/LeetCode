import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = getAString(strings[i]);
            if (map.containsKey(s)) {
                map.get(s).add(strings[i]);
            } else {
                map.put(s, new ArrayList<>());
                map.get(s).add(strings[i]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }

    private String getAString(String s) {
        char min = s.charAt(0);
        int diff = min - 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((char) (s.charAt(i) - 'a' - diff + 26) % 26 + 'a');
        }
        return sb.toString();
    }
}
