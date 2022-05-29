import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int totalSteps(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] count = new int[nums.length];
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                count[i] = Math.max(count[i] + 1, count[stack.pop()]);
            }
            stack.push(i);
            res = Math.max(res, count[i]);
        }
        return res;
    }
}
