import java.util.Random;

class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int q) {
        if (left > right) {
            return Integer.MAX_VALUE;
        }
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == q) {
            return nums[pivotIndex];
        } else if (pivotIndex > q) {
            return quickSelect(nums, left, pivotIndex - 1, q);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, q);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, pivotIndex);
        int pivotValue = nums[left];
        int lessThanPivotIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivotValue) {
                lessThanPivotIndex++;
                swap(nums, i, lessThanPivotIndex);
            }
        }
        swap(nums, left, lessThanPivotIndex);
        return lessThanPivotIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
