class Solution3 {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target >= nums[0]) {
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
