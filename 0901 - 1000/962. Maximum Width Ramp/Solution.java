import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty() || nums[deque.peek()] > nums[i]) {
                deque.push(i);
            }
        }
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[i]) {
                int index = deque.poll();
                res = Math.max(res, i - index);
            }
        }
        return res;
    }
}
