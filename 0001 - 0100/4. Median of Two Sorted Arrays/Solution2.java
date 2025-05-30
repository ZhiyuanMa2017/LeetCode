class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int cur = 0;
        int last = 0;
        for (int step = 0; step <= (m + n) / 2; step++) {
            last = cur;
            if (i >= n) {
                cur = nums2[j];
                j++;
            } else if (j >= m) {
                cur = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                cur = nums1[i];
                i++;
            } else {
                cur = nums2[j];
                j++;
            }
        }
        if ((m + n) % 2 == 1) {
            return cur;
        } else {
            return (double) (last + cur) / 2;
        }
    }
}
