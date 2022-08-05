import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int i = 0;
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            while (!max.isEmpty() && nums[j] > max.peekLast()) {
                max.pollLast();
            }
            while (!min.isEmpty() && nums[j] < min.peekLast()) {
                min.pollLast();
            }
            max.addLast(nums[j]);
            min.addLast(nums[j]);
            while (!max.isEmpty() && !min.isEmpty() && max.peekFirst() - min.peekFirst() > limit) {
                if (max.peekFirst() == nums[i]) {
                    max.pollFirst();
                }
                if (min.peekFirst() == nums[i]) {
                    min.pollFirst();
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
