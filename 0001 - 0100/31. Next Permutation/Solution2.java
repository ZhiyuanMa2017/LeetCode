class Solution2 {
    public void nextPermutation(int[] nums) {
        int index = findLast(nums);
        int pivot = index - 1;
        if (pivot != -1) {
            int rightMost = findRight(nums, nums[pivot]);
            swap(nums, pivot, rightMost);
        }
        reverse(nums, pivot + 1);
    }


    private int findLast(int[] nums) {
        int index = nums.length - 1;
        while (index > 0 && nums[index] <= nums[index - 1]) {
            index--;
        }
        return index;
    }

    private int findRight(int[] nums, int target) {
        int index = nums.length - 1;
        while (index >= 0 && nums[index] <= target) {
            index--;
        }
        return index;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
