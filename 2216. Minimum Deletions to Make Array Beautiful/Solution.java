import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int minDeletion(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (stack.size() % 2 == 0) {
                    stack.push(num);
                } else {
                    if (stack.peek() != num) {
                        stack.push(num);
                    }
                }
            }
        }
        if (stack.size() % 2 == 0) {
            return nums.length - stack.size();
        }
        return nums.length - stack.size() + 1;
    }
}
