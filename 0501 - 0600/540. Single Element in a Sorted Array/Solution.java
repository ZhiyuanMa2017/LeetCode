class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (mid % 2 != 0) {
                mid -= 1;
            }
            if (nums[mid] != nums[mid + 1]) {
                h = mid;
            } else {
                l = mid + 2;
            }
        }
        return nums[l];
    }
}
