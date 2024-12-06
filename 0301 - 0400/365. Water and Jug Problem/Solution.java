import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited.add(hash(0, 0));
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int a = cur[0];
            int b = cur[1];
            if (a == target || b == target || a + b == target) {
                return true;
            }
            int a1 = x;
            int b1 = b;
            if (!visited.contains(hash(a1, b1))) {
                queue.offer(new int[]{a1, b1});
                visited.add(hash(a1, b1));
            }
            a1 = a;
            b1 = y;
            if (!visited.contains(hash(a1, b1))) {
                queue.offer(new int[]{a1, b1});
                visited.add(hash(a1, b1));
            }
            a1 = 0;
            b1 = b;
            if (!visited.contains(hash(a1, b1))) {
                queue.offer(new int[]{a1, b1});
                visited.add(hash(a1, b1));
            }
            a1 = a;
            b1 = 0;
            if (!visited.contains(hash(a1, b1))) {
                queue.offer(new int[]{a1, b1});
                visited.add(hash(a1, b1));
            }
            int[] case1 = pour(x, y, a, b);
            if (!visited.contains(hash(case1[0], case1[1]))) {
                queue.offer(case1);
                visited.add(hash(case1[0], case1[1]));
            }
            int[] case2 = pour2(x, y, a, b);
            if (!visited.contains(hash(case2[0], case2[1]))) {
                queue.offer(case2);
                visited.add(hash(case2[0], case2[1]));
            }
        }
        return false;
    }

    private int[] pour2(int x, int y, int a, int b) {
        int a1 = 0;
        int b1 = 0;
        if (b > x - a) {
            a1 = x;
            b1 = b - (x - a);
        } else {
            a1 = a + b;
            b1 = 0;
        }
        return new int[]{a1, b1};
    }

    private int[] pour(int x, int y, int a, int b) {
        int a1 = 0;
        int b1 = 0;
        if (a > y - b) {
            a1 = a - (y - b);
            b1 = y;
        } else {
            a1 = 0;
            b1 = b + a;
        }
        return new int[]{a1, b1};
    }

    private int hash(int a, int b) {
        return a * 100000 + b;
    }
}
