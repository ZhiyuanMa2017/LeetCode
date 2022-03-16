import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        int j = 0;
        int i = 0;
        while (i < n) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            i++;
        }
        return j == n;
    }
}
