class Solution2 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    h = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
}
