class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n * 6 < m || n > m * 6) {
            return -1;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i : nums1) {
            sum1 += i;
        }
        for (int i : nums2) {
            sum2 += i;
        }
        if (sum1 == sum2) {
            return 0;
        } else if (sum1 > sum2) {
            return cal(nums1, nums2, sum1, sum2);
        } else {
            return cal(nums2, nums1, sum2, sum1);
        }
    }

    private int cal(int[] nums1, int[] nums2, int sum1, int sum2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] count = new int[6];
        for (int i : nums1) {
            count[i - 1]++;
        }
        for (int i : nums2) {
            count[6 - i]++;
        }
        int cur = 5;
        int res = 0;
        while (sum1 > sum2) {
            while (count[cur] == 0) {
                cur--;
            }
            sum1 -= cur;
            count[cur]--;
            res++;
        }
        return res;
    }
}
