class Solution3 {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int l = 0;
        int r = n - 1;
        int res = 0;
        int count = 0;
        while (l < n && seats[l] == 0) {
            count++;
            l++;
        }
        if (l == n - 1) {
            return count;
        }
        res = count;
        count = 0;
        while (r >= 0 && seats[r] == 0) {
            count++;
            r--;
        }
        res = Math.max(res, count);
        count = 0;
        for (int i = l + 1; i <= r; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                res = Math.max(res, (count + 1) / 2);
                count = 0;
            }
        }
        return res;
    }
}
