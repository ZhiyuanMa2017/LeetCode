import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int remain = (num % k + k) % k;
            map.put(remain, map.getOrDefault(remain, 0) + 1);
        }
        Set<Integer> checked = new HashSet<>();
        for (Integer key : map.keySet()) {
            int another = k - key;
            if (checked.contains(another)) {
                continue;
            }
            if (key == 0 || key == another) {
                if (map.get(key) % 2 != 0) {
                    return false;
                }
            } else {
                if (!map.containsKey(another) || !map.get(key).equals(map.get(another))) {
                    return false;
                }
            }
            checked.add(key);
        }
        return true;
    }
}
