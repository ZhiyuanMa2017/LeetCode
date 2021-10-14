import java.util.ArrayList;
import java.util.List;

class Solution2 {
    static List<Integer> dp = new ArrayList<>();

    public int numSquares(int n) {
        if (dp.isEmpty()) {
            dp.add(0);
        }
        if (dp.size() <= n) {
            for (int i = dp.size(); i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, dp.get(i - j * j) + 1);
                }
                dp.add(min);
            }
        }
        return dp.get(n);
    }
}
