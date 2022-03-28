class Solution2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return true;
            } else {
                if (nums[m] > nums[l]) {
                    if (target >= nums[l] && target < nums[m]) {
                        h = m;
                    } else {
                        l = m + 1;
                    }
                } else if (nums[m] < nums[l]) {
                    if (target > nums[m] && target <= nums[h]) {
                        l = m + 1;
                    } else {
                        h = m;
                    }
                } else {
                    l++;
                }
            }
        }
        return nums[l] == target;
    }
}
