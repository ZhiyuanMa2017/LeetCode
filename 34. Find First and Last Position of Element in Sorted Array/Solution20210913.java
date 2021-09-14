class Solution20210913 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = findFirst(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int right = findLast(nums, target);
        return new int[]{left, right};
    }

    private int findFirst(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                h = mid;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    private int findLast(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l + 1) / 2;
            if (nums[mid] == target) {
                l = mid;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[h] == target ? h : -1;
    }
}
