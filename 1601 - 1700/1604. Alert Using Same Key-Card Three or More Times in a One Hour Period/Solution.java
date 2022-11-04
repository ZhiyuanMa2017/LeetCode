import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> nameToTime = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            if (!nameToTime.containsKey(name)) {
                nameToTime.put(name, new ArrayList<>());
            }
            nameToTime.get(name).add(time);
        }
        List<String> res = new ArrayList<>();
        for (String s : nameToTime.keySet()) {
            List<String> times = nameToTime.get(s);
            Collections.sort(times);
            for (int i = 0; i < times.size() - 2; i++) {
                if (getTime(times.get(i)) + 60 >= getTime(times.get(i + 2))) {
                    res.add(s);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }


    private int getTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }
}
