import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int size = map.size();
        int[] count = new int[arr.length + 1];
        for (Integer value : map.values()) {
            count[value]++;
        }
        int occur = 1;
        while (k > 0) {
            if (k >= occur * count[occur]) {
                k -= occur * count[occur];
                size -= count[occur];
                occur++;
            } else {
                return size - k / occur;
            }
        }
        return size;
    }
}
