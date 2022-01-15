class Solution20220115 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int n = nums.length;
        int[] res = new int[2];
        int l = 0;
        int h = n - 1;
        // find first
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        res[0] = l;

        l = 0;
        h = n - 1;
        // find last
        while (l < h) {
            int mid = l + (h - l + 1) / 2;
            if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        res[1] = l;
        return res;
    }
}
