class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum - n + 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int num, int n, int index, int maxSum) {
        int len1 = index;
        long total = 0;
        if (num >= len1 + 1) {
            total += (long) (len1 + 1) * (num + num - len1) / 2;
        } else {
            total += (long) (1 + num) * num / 2;
            total += len1 + 1 - num;
        }
        int len2 = n - index - 1;
        if (num >= len2 + 1) {
            total += (long) (len2 + 1) * (num + num - len2) / 2;
        } else {
            total += (long) (1 + num) * num / 2;
            total += len2 + 1 - num;
        }
        return total - num <= maxSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxValue(4, 2, 6));
    }
}
