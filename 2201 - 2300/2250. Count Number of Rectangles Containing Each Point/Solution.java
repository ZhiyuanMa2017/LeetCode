import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[] ys = new ArrayList[101];
        for (int i = 0; i < 101; i++) {
            ys[i] = new ArrayList<>();
        }
        for (int[] rectangle : rectangles) {
            int x = rectangle[0];
            int y = rectangle[1];
            ys[y].add(x);
        }
        for (int i = 1; i < 101; i++) {
            Collections.sort(ys[i]);
        }
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int cur = 0;
            for (int j = y; j < 101; j++) {
                cur += binarySearch(ys[j], x);
            }
            res[i] = cur;
        }
        return res;
    }

    private int binarySearch(List<Integer> list, int x) {
        if (list.size() == 0) {
            return 0;
        }
        int l = 0;
        int h = list.size();
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (list.get(mid) == x) {
                return list.size() - mid;
            } else if (list.get(mid) < x) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return list.size() - l;
    }
}
