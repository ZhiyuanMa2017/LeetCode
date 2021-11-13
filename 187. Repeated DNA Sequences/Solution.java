import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub)) {
                if (map.get(sub) != -1) {
                    res.add(sub);
                    map.put(sub, -1);
                }
            } else {
                map.put(sub, 1);
            }
        }
        return res;
    }
}
