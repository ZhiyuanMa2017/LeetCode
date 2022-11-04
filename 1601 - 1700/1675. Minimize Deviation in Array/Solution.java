import java.util.PriorityQueue;

class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1) {
                num *= 2;
            }
            pq.offer(num);
            min = Math.min(min, num);
        }

        while (true) {
            int curMax = pq.poll();
            res = Math.min(res, curMax - min);
            if (curMax % 2 == 1) {
                break;
            }
            curMax /= 2;
            min = Math.min(min, curMax);
            pq.offer(curMax);
        }
        return res;
    }
}
