class Solution2 {
    int total;
    int[] arr;

    public int maxProfit(int[] inventory, int orders) {
        total = orders;
        arr = inventory;
        int l = 0;
        int h = 0;
        for (int num : inventory) {
            h = Math.max(h, num);
        }
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (cal(mid)) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        int minHeight = l;
        long res = 0;
        int mod = 1000000007;
        for (int height : inventory) {
            if (height > minHeight) {
                int count = height - minHeight;
                res = (res + (long) (height + minHeight + 1) * count / 2) % mod;
                orders -= count;
            }
        }
        res = (res + (long) (minHeight) * orders) % mod;
        return (int) res;
    }

    private boolean cal(int minHeight) {
        int res = 0;
        for (int num : arr) {
            if (num > minHeight) {
                res += num - minHeight;
                if (res > total) {
                    return true;
                }
            }
        }
        return false;
    }
}
