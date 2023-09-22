import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int validSubarrays(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0;
        for (int num : nums) {
            while (!deque.isEmpty() && deque.peek() > num) {
                deque.pop();
            }
            deque.push(num);
            res++;
            res += deque.size() - 1;
        }
        return res;
    }
}
