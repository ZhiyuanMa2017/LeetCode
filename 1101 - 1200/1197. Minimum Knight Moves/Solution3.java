import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> memo;

    public int minKnightMoves(int x, int y) {
        memo = new HashMap<>();
        return dfs(x, y);
    }

    private int dfs(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Integer key = x * 301 + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (x == 0 && y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        } else {
            int res = Math.min(dfs(x - 2, y - 1), dfs(x - 1, y - 2)) + 1;
            memo.put(key, res);
            return res;
        }
    }
}
