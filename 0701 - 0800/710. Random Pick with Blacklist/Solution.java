import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    Map<Integer, Integer> map;
    Random random;
    int len;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        for (int b : blacklist) {
            map.put(b, -1);
        }
        len = n - map.size();
        int last = n - 1;
        for (int b : blacklist) {
            if (b < len) {
                while (map.containsKey(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }
        }
    }

    public int pick() {
        int key = random.nextInt(len);
        return map.getOrDefault(key, key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
