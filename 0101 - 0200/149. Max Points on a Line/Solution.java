import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int curMax = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int diffX = x1 - x2;
                int diffY = y1 - y2;
                int greatestCommonDivisor = gcd(diffX, diffY);
                String key = diffX / greatestCommonDivisor + "-" + diffY / greatestCommonDivisor;
                map.put(key, map.getOrDefault(key, 0) + 1);
                curMax = Math.max(curMax, map.get(key));
            }
            res = Math.max(res, curMax + 1);
        }
        return res;
    }


    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
