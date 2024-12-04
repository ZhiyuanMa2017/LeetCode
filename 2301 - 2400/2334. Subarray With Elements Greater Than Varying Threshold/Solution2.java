import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        Deque<Integer> increasing = new ArrayDeque<>();
        int[] rightSmallest = new int[n];
        for (int i = 0; i < n; i++) {
            rightSmallest[i] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            while (!increasing.isEmpty() && nums[increasing.peekLast()] > nums[i]) {
                int last = increasing.pollLast();
                rightSmallest[last] = i;
            }
            increasing.addLast(i);
        }
        while (!increasing.isEmpty()) {
            int last = increasing.pollLast();
            rightSmallest[last] = n;
        }
        Deque<Integer> decreasing = new ArrayDeque<>();
        int[] leftSmallest = new int[n];
        for (int i = 0; i < n; i++) {
            leftSmallest[i] = i - 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!decreasing.isEmpty() && nums[decreasing.peekFirst()] > nums[i]) {
                int first = decreasing.pollFirst();
                leftSmallest[first] = i;
            }
            decreasing.addFirst(i);
        }
        while (!decreasing.isEmpty()) {
            int first = decreasing.pollFirst();
            leftSmallest[first] = -1;
        }
        for (int i = 0; i < n; i++) {
            int len = rightSmallest[i] - leftSmallest[i] - 1;
            if (nums[i] > threshold / len) {
                return len;
            }
        }
        return -1;
    }
}
