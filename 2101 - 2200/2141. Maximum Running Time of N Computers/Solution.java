class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        long l = 0;
        long h = sum / n;
        while (l < h) {
            long day = l + (h - l + 1) / 2;
            if (check(n, day, batteries)) {
                l = day;
            } else {
                h = day - 1;
            }
        }
        return l;
    }

    private boolean check(int n, long b, int[] batteries) {
        long need = n * b;
        long sum = 0;
        for (int battery : batteries) {
            sum += Math.min(battery, b);
            if (sum >= need) {
                return true;
            }
        }
        return sum >= need;
    }
}
