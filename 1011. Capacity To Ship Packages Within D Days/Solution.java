class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int h = 25000000;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (check(weights, days, mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] weights, int days, int capacity) {
        int res = 0;
        int cur = 0;
        for (int weight : weights) {
            if (cur + weight <= capacity) {
                cur += weight;
            } else {
                if (weight <= capacity) {
                    res++;
                    cur = weight;
                } else {
                    return false;
                }
            }
        }
        return res + 1 <= days;
    }
}
