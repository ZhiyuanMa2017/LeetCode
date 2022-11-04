import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] t = target.toCharArray();
        char[] s = stamp.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        int n = t.length;
        int m = s.length;
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i <= n - m; i++) {
                if (place(s, t, i)) {
                    stack.push(i);
                    change = true;
                }
            }
        }
        for (int i = 0; i < t.length; i++) {
            if (t[i] != '*') {
                return new int[]{};
            }
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index] = stack.pop();
            index++;
        }
        return res;
    }

    private boolean place(char[] s, char[] t, int i) {
        boolean change = false;
        for (int j = 0; j < s.length; j++) {
            if (t[i + j] == '*') {
                continue;
            }
            if (t[i + j] != s[j]) {
                return false;
            } else {
                change = true;
            }
        }
        if (change) {
            for (int j = 0; j < s.length; j++) {
                t[i + j] = '*';
            }
        }
        return change;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.movesToStamp("abc", "ababc");
    }
}
