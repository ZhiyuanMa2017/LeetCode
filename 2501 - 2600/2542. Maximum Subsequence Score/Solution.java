import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            nums[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(nums, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        long res = 0;
        long curSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            pq.offer(nums[i][0]);
            curSum += nums[i][0];
            if (pq.size() > k) {
                curSum -= pq.poll();
            }
            if (pq.size() == k) {
                res = Math.max(res, curSum * nums[i][1]);
            }
        }
        return res;
    }
}
