import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    class Node {
        String value;
        int timestamp;

        Node(String v, int t) {
            value = v;
            timestamp = t;
        }
    }

    Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Node> list = map.get(key);
        int l = 0;
        int r = list.size() - 1;
        // biggest value less than or equal to target
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (list.get(mid).timestamp > timestamp) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (list.get(l).timestamp <= timestamp) {
            return list.get(l).value;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
