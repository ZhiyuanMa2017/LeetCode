class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (m == 1) {
            return sum;
        }
        int l = max;
        int h = sum;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int count = 1;
            int cur = 0;
            for (int num : nums) {
                cur += num;
                if (cur > mid) {
                    cur = num;
                    count++;
                }
            }
            if (count > m) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
