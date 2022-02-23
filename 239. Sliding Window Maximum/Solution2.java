import java.util.PriorityQueue;

class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{i, nums[i]});
        }
        res[0] = pq.peek()[1];
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            pq.add(new int[]{i, nums[i]});
            while (pq.peek()[0] + k <= i) {
                pq.poll();
            }
            res[index] = pq.peek()[1];
            index++;
        }
        return res;
    }
}
