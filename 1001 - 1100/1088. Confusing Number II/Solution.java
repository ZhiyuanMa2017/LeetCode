import java.util.HashMap;
import java.util.Map;

class Solution {
    int res;

    public int confusingNumberII(int n) {
        res = 0;
        Map<Integer, Integer> map = new HashMap<>() {
            {
                put(0, 0);
                put(1, 1);
                put(6, 9);
                put(8, 8);
                put(9, 6);
            }
        };
        for (Integer key : map.keySet()) {
            if (key == 0) {
                continue;
            }
            backtrack(key, map.get(key), map, n, 10);
        }

        return res;
    }

    private void backtrack(long num, long rotation, Map<Integer, Integer> map, int n, long digit) {
        if (num != rotation) {
            res++;
        }
        for (Integer key : map.keySet()) {
            if (num * 10 + key > n) {
                continue;
            }
            backtrack(num * 10 + key, map.get(key) * digit + rotation, map, n, digit * 10);
        }
    }
}
