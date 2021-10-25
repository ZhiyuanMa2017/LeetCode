import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public String getPermutation(int n, int k) {
        k--;
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(nums.remove(index));
            k -= index * factorial[i];
        }
        return sb.toString();
    }
}
