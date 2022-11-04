import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        StringBuilder sb;
        int i = 0;
        for (String name : names) {
            if (!map.containsKey(name)) {
                res[i] = name;
                map.put(name, 0);
                i++;
            } else {
                sb = new StringBuilder();
                int val = map.get(name);
                val++;
                sb.append(name).append("(").append(val).append(")");
                while (map.containsKey(sb.toString())) {
                    sb = new StringBuilder();
                    val++;
                    sb.append(name).append("(").append(val).append(")");
                }
                res[i] = sb.toString();
                map.put(name, val);
                map.put(sb.toString(), 0);
                i++;
            }
        }
        return res;
    }
}
