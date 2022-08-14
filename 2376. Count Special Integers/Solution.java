import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int countSpecialNumbers(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = n + 1; i > 0; i /= 10) {
            list.add(0, i % 10);
        }
        int res = 0;
        int size = list.size();
        // count the number with length < n, from 1 to size - 1
        // X, XX, XXX
        for (int len = 1; len < size; len++) {
            res += 9 * A(9, len - 1);
        }
        // count the number with sam prefix with n
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int start;
            if (i == 0) {
                start = 1;
            } else {
                start = 0;
            }
            for (int curDigit = start; curDigit < list.get(i); curDigit++) {
                if (!set.contains(curDigit)) {
                    // now we have set the front i + 1 digits, so the left length is size - i - 1, and what we can choose is 10 - i - 1
                    res += A(10 - i - 1, size - i - 1);
                }
            }
            // if the current digit has been seen, we cannot continue this, for example: 50500 -> 505XX
            if (set.contains(list.get(i))) {
                break;
            }
            set.add(list.get(i));
        }
        return res;
    }

    private int A(int m, int n) {
        if (n == 0) {
            return 1;
        }
        return A(m, n - 1) * (m - (n - 1));
    }
}
