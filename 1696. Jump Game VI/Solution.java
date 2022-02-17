import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maxResult(int[] nums, int k) {
        int res = 0;
        int[] score = new int[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        score[0] = nums[0];
        deque.offerLast(0);
        for (int i = 1; i < nums.length; i++) {
            while (!deque.isEmpty() && i - k > deque.peekFirst()) {
                deque.pollFirst();
            }
            score[i] = score[deque.peekFirst()] + nums[i];
            while (!deque.isEmpty() && score[deque.peekLast()] <= score[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return score[nums.length - 1];
    }
}
