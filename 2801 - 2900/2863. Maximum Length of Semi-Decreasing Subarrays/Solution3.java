import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxSubarrayLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        Deque<Integer> increasing = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (increasing.isEmpty()) {
                increasing.push(i);
            } else if (nums[i] < nums[increasing.peek()]) {
                increasing.push(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (increasing.isEmpty()) {
                break;
            }
            while (!increasing.isEmpty() && nums[i] > nums[increasing.peek()]) {
                res = Math.max(res, increasing.pop() - i + 1);
            }
        }
        return res;
    }
}
