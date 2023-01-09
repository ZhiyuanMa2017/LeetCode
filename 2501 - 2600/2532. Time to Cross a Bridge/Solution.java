import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int t1 = time[o1][0] + time[o1][2];
                int t2 = time[o2][0] + time[o2][2];
                if (t1 != t2) {
                    return t2 - t1;
                } else {
                    return o2 - o1;
                }
            }
        };
        PriorityQueue<Integer> left = new PriorityQueue<>(comparator);
        for (int i = 0; i < k; i++) {
            left.offer(i);
        }
        PriorityQueue<Integer> right = new PriorityQueue<>(comparator);
        PriorityQueue<int[]> old = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> neww = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Deque<int[]> lToR = new ArrayDeque<>();
        Deque<int[]> rToL = new ArrayDeque<>();
        int cur = 0;
        while (true) {
            if (!rToL.isEmpty()) {
                int[] w = rToL.poll();
                int worker = w[0];
                int endTime = w[1];
                old.offer(new int[]{worker, time[worker][3] + endTime});
                cur = endTime;
            } else if (!lToR.isEmpty()) {
                int[] w = lToR.poll();
                int worker = w[0];
                int endTime = w[1];
                neww.offer(new int[]{worker, time[worker][1] + endTime});
                cur = endTime;
            } else if (!right.isEmpty()) {
                int worker = right.poll();
                rToL.push(new int[]{worker, time[worker][2] + cur});
            } else if (!left.isEmpty() && n > 0) {
                int w = left.poll();
                lToR.push(new int[]{w, time[w][0] + cur});
                n--;
            } else {
                if (!old.isEmpty() && !neww.isEmpty()) {
                    if (old.peek()[1] <= neww.peek()[1]) {
                        int[] w = old.poll();
                        left.offer(w[0]);
                        cur = w[1];
                    } else {
                        int[] w = neww.poll();
                        right.offer(w[0]);
                        cur = w[1];
                    }
                } else if (!old.isEmpty()) {
                    int[] w = old.poll();
                    left.offer(w[0]);
                    cur = w[1];
                } else if (!neww.isEmpty()) {
                    int[] w = neww.poll();
                    right.offer(w[0]);
                    cur = w[1];
                }
            }
            while (!old.isEmpty() && old.peek()[1] <= cur) {
                int[] w = old.poll();
                left.offer(w[0]);
            }
            while (!neww.isEmpty() && neww.peek()[1] <= cur) {
                int[] w = neww.poll();
                right.offer(w[0]);
            }
            if (n == 0 && neww.isEmpty() && rToL.isEmpty() && lToR.isEmpty() && right.isEmpty()) {
                break;
            }
        }
        return cur;
    }
}
