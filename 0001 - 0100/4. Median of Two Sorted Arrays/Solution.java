class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 < length2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // # 1 # 3 # 5 # 7 # length1 = 4 total = 4 * 2 + 1 = 9
        // # 1 # 3 # 5 #     length2 = 3 total = 3 * 2 + 1 = 7
        // "#" means cut place
        // mid2 = 3 --> mid1 = 4 + 3 - 3 = 4
        // since mid1 + mid2 = (total1 + total2 - 2)/2 = length1 + length2

        // # 1 # 3 / 5 # 7 #
        // # 1 # (3/3) # 5 #
        // l1 = (mid1 - 1)/2     r1 = mid1/2
        // l2 = (mid2 - 1)/2     r2 = mid2/2
        int low = 0;
        int high = 2 * length2;
        while (low <= high) {
            int mid2 = low + (high - low) / 2;
            int mid1 = length1 + length2 - mid2;

            double L1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == 2 * length1 ? Integer.MAX_VALUE : nums1[(mid1 / 2)];
            double R2 = mid2 == 2 * length2 ? Integer.MAX_VALUE : nums2[(mid2 / 2)];

            if (L1 > R2) {
                low = mid2 + 1;
            } else if (L2 > R1) {
                high = mid2 - 1;
            } else {
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            }
        }
        return -1;
    }
}
