import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.offer(num);
        }
        while (k > 0) {
            int cur = pq.poll();
            res += cur;
            k--;
            pq.offer((cur + 2) / 3);
        }
        return res;
    }
}
