import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= s.length(); i++) {
            stack.push(i);
            if (s.charAt(i - 1) == 'I') {
                while (!stack.isEmpty()) {
                    res[index] = stack.pop();
                    index++;
                }
            }
        }
        stack.push(s.length() + 1);
        while (!stack.isEmpty()) {
            res[index] = stack.pop();
            index++;
        }
        return res;
    }
}
