import java.util.TreeSet;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int modulo = 1000000007;
        int maxSubtract = 0;
        int n = nums1.length;
        long sum = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : nums1) {
            treeSet.add(i);
        }
        for (int i = 0; i < n; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
            if (nums1[i] == nums2[i]) {
                continue;
            }
            Integer ceil = treeSet.ceiling(nums2[i]);
            Integer floor = treeSet.floor(nums2[i]);
            int thisDiff = Math.abs(nums1[i] - nums2[i]);
            int thisMax = 0;
            if (ceil != null) {
                int diff1 = Math.abs(ceil - nums2[i]);
                thisMax = Math.max(thisMax, thisDiff - diff1);
            }
            if (floor != null) {
                int diff2 = Math.abs(floor - nums2[i]);
                thisMax = Math.max(thisMax, thisDiff - diff2);
            }
            maxSubtract = Math.max(maxSubtract, thisMax);
        }
        return (int) ((sum - maxSubtract) % modulo);
    }
}
