class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 100000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int quantity : quantities) {
                count += (quantity + mid - 1) / mid;
            }
            if (count > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
