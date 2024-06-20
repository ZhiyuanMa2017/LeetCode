import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int l = 1;
        int r = (int) 1e9;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            int cur = check(position, mid);
            if (cur >= m) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int check(int[] position, int force) {
        int n = position.length;
        int res = 1;
        int cur = position[0];
        for (int i = 1; i < n; i++) {
            if (position[i] - cur >= force) {
                res++;
                cur = position[i];
            }
        }
        return res;
    }
}
