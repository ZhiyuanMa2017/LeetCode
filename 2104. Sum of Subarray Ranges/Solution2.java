import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                right[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        System.out.println(Arrays.toString(right));
        int[] left = new int[n];
        Arrays.fill(left, -1);
        stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
                left[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            res -= (long) nums[i] * (i - left[i]) * (right[i] - i);
        }

        Arrays.fill(right, n);
        stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                right[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        Arrays.fill(left, -1);
        stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                left[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            res += (long) nums[i] * (i - left[i]) * (right[i] - i);
        }
        return res;
    }
}
