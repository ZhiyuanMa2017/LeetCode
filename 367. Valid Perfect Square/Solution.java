class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int l = 1;
        int h = num;
        while (l < h) {
            int mid = l + (h - l) / 2;
            long product = (long) mid * mid;
            if (product == num) {
                return true;
            } else if (product < num) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return false;
    }
}
