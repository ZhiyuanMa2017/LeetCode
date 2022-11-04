import java.util.Arrays;

class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        k = k - n;
        int i = n - 1;
        while (k > 0) {
            int num = Math.min(25, k);
            res[i] += num;
            k -= num;
            i--;
        }
        return String.copyValueOf(res);
    }
}