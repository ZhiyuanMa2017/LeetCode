import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        int left = -1;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                queue.offer(right);
            }
            if (queue.size() > 1) {
                left = queue.poll();
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
