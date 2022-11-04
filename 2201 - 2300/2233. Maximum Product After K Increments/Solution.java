import java.util.PriorityQueue;

class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        while (k > 0) {
            pq.offer(pq.poll() + 1);
            k--;
        }
        long res = 1;
        while (!pq.isEmpty()) {
            res = res * pq.poll() % mod;
        }
        return (int) res;
    }
}
