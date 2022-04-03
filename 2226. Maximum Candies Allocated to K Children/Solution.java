class Solution {
    public int maximumCandies(int[] candies, long k) {
        int l = 0;
        int h = 10000000;
        while (l < h) {
            int mid = l + (h - l + 1) / 2;
            if (count(candies, mid) >= k) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    private long count(int[] candies, int pile) {
        long res = 0;
        for (int candy : candies) {
            res += candy / pile;
        }
        return res;
    }
}
