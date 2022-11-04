class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = binarysearchfirst(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }
        int last = binarysearchfirst(nums, target + 1) - 1;
        return new int[]{first, last};
    }

    public int binarysearchfirst(int[] nums, int target) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                h = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
