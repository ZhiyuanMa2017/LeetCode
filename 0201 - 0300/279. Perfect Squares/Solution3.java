import java.util.HashMap;
import java.util.Map;

class Solution3 {
    static Map<Integer, Integer> map = new HashMap<>();

    public int numSquares(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, dfs(n - i * i) + 1);
        }
        map.put(n, min);
        return min;
    }
}
