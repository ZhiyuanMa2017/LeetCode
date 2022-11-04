class Solution20211219 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 < length2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = 2 * length2;
        while (low < high) {
            int mid2 = low + (high - low) / 2;
            int mid1 = length1 + length2 - mid2;

            double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];

            double r2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            double r1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];

            if (l2 > r1) {
                high = mid2;
            } else if (l1 > r2) {
                low = mid2 + 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }
        int mid2 = low + (high - low) / 2;
        int mid1 = length1 + length2 - mid2;

        double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
        double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];

        double r2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
        double r1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];

        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMedianSortedArrays(new int[]{2}, new int[]{1});
    }
}
