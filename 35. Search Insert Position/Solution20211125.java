class Solution20211125 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
