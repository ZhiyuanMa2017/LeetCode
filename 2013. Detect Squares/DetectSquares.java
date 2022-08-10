import java.util.HashMap;
import java.util.Map;

class DetectSquares {
    Map<Integer, Map<Integer, Integer>> row2col;

    public DetectSquares() {
        row2col = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        if (!row2col.containsKey(x)) {
            row2col.put(x, new HashMap<>());
        }
        row2col.get(x).put(y, row2col.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0];
        int y = point[1];
        Map<Integer, Integer> col2val = row2col.getOrDefault(x, new HashMap<>());
        for (Integer yy : col2val.keySet()) {
            if (yy == y) {
                continue;
            }
            int xYyCount = col2val.get(yy);
            int len = y - yy;
            int[] xs = new int[]{x + len, x - len};
            for (int xx : xs) {
                Map<Integer, Integer> xxCol2Val = row2col.getOrDefault(xx, new HashMap<>());
                int xxYCount = xxCol2Val.getOrDefault(y, 0);
                int xxYyCount = xxCol2Val.getOrDefault(yy, 0);
                res += xYyCount * xxYCount * xxYyCount;
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
