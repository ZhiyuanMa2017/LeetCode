import java.util.Stack;

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;
        for (int val : preorder) {
            while (!stack.isEmpty() && val > stack.peek()) {
                prev = stack.pop();
            }
            if (val < prev) {
                return false;
            }
            stack.push(val);
        }
        return true;
    }
}
