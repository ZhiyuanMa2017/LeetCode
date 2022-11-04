class Solution2 {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[l] <= nums[mid]) {
                    if (target <= nums[mid] && target >= nums[l]) {
                        h = mid;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (target >= nums[mid] && target <= nums[h]) {
                        l = mid + 1;
                    } else {
                        h = mid;
                    }
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
}
