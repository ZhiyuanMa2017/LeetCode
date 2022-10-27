import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    a.add(flat(i, j));
                }
                if (img2[i][j] == 1) {
                    b.add(flat(i, j));
                }
            }
        }
        Map<Integer, Integer> dis = new HashMap<>();
        for (Integer aa : a) {
            for (Integer bb : b) {
                int d = aa - bb;
                dis.put(d, dis.getOrDefault(d, 0) + 1);
            }
        }
        int res = 0;
        for (Integer key : dis.keySet()) {
            if (dis.get(key) > res) {
                res = dis.get(key);
            }
        }
        return res;
    }

    private int flat(int x, int y) {
        return (x << 6) + y;
    }
}
