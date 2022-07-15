import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int[][] dis = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        int one = -1;
        int two = -1;
        int three = -1;
        for (int i = 0; i < n; i++) {
            if (colors[i] == 1) {
                one = 0;
            } else if (colors[i] == 2) {
                two = 0;
            } else if (colors[i] == 3) {
                three = 0;
            }
            if (one != -1) {
                dis[i][0] = Math.min(dis[i][0], one);
                one++;
            }
            if (two != -1) {
                dis[i][1] = Math.min(dis[i][1], two);
                two++;
            }
            if (three != -1) {
                dis[i][2] = Math.min(dis[i][2], three);
                three++;
            }
        }
        one = -1;
        two = -1;
        three = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] == 1) {
                one = 0;
            } else if (colors[i] == 2) {
                two = 0;
            } else if (colors[i] == 3) {
                three = 0;
            }
            if (one != -1) {
                dis[i][0] = Math.min(dis[i][0], one);
                one++;
            }
            if (two != -1) {
                dis[i][1] = Math.min(dis[i][1], two);
                two++;
            }
            if (three != -1) {
                dis[i][2] = Math.min(dis[i][2], three);
                three++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            int index = query[0];
            int color = query[1];
            if (dis[index][color - 1] != Integer.MAX_VALUE) {
                res.add(dis[index][color - 1]);
            } else {
                res.add(-1);
            }
        }
        return res;
    }
}
