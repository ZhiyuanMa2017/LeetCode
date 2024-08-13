class Solution2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (0 < r && nums[r] == nums[0]) {
            r--;
        }
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (target >= nums[0]) {
            l = 0;
        } else {
            l = l + 1;
            r = n - 1;
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r] == target;
    }
}
