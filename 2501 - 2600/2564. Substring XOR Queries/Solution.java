import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = s.length();
        int max = (int) 1e9;
        Map<Integer, int[]> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] query : queries) {
            int value = query[0] ^ query[1];
            set.add(value);
        }
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < n; j++) {
                if (cur > max / 2) {
                    break;
                }
                cur = cur * 2 + (s.charAt(j) == '0' ? 0 : 1);
                if (set.contains(cur)) {
                    if (!map.containsKey(cur)) {
                        map.put(cur, new int[]{i, j, j - i + 1});
                    } else {
                        int[] prev = map.get(cur);
                        if (prev[2] > j - i + 1) {
                            map.put(cur, new int[]{i, j, j - i + 1});
                        }
                    }
                }
            }
        }
        int m = queries.length;
        int[][] res = new int[m][2];
        for (int i = 0; i < m; i++) {
            int value = queries[i][0] ^ queries[i][1];
            if (!map.containsKey(value)) {
                res[i] = new int[]{-1, -1};
            } else {
                int[] prev = map.get(value);
                res[i] = new int[]{prev[0], prev[1]};
            }
        }
        return res;
    }
}
