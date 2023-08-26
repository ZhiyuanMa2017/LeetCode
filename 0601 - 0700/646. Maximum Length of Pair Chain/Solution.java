import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int curEnd = -1001;
        int res = 0;
        for (int[] pair : pairs) {
            if (pair[0] > curEnd) {
                curEnd = pair[1];
                res++;
            }
        }
        return res;
    }
}
