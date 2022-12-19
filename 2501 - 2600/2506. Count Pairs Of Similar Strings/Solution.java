import java.util.HashMap;
import java.util.Map;

class Solution {
    public int similarPairs(String[] words) {
        int n = words.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        int res = 0;
        for (Integer value : map.values()) {
            res += value * (value - 1) / 2;
        }
        return res;
    }
}
