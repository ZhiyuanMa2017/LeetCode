import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] parts = domain.split(" ");
            String[] d = parts[1].split("\\.");
            int count = Integer.parseInt(parts[0]);
            String cur = d[d.length - 1];
            map.put(cur, map.getOrDefault(cur, 0) + count);
            for (int i = d.length - 2; i >= 0; i--) {
                cur = d[i] + "." + cur;
                map.put(cur, map.getOrDefault(cur, 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            String s = "" + map.get(key) + " " + key;
            res.add(s);
        }
        return res;
    }
}
