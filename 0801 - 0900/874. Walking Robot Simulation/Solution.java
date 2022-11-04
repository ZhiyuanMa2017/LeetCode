import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "-" + obstacle[1]);
        }
        int x = 0;
        int y = 0;
        int d = 0;
        int res = 0;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        for (int command : commands) {
            if (command == -2) {
                d = (d - 1 + 4) % 4;
            } else if (command == -1) {
                d = (d + 1) % 4;
            } else {
                int unit = 0;
                while (unit < command && !set.contains((x + dirs[d]) + "-" + (y + dirs[d + 1]))) {
                    x = x + dirs[d];
                    y = y + dirs[d + 1];
                    res = Math.max(res, x * x + y * y);
                    unit++;
                }
            }
        }
        return res;
    }
}
