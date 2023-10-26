import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = (int) 1e9 + 7;
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                int v = arr[j];
                if (arr[i] % v == 0) {
                    int left = arr[i] / v;
                    if (map.containsKey(left)) {
                        map.put(arr[i], (map.get(arr[i]) + map.get(v) * map.get(left) % mod) % mod);
                    }
                }
            }
        }
        long res = 0;
        for (Integer key : map.keySet()) {
            res = (res + map.get(key)) % mod;
        }
        return (int) res;
    }
}
