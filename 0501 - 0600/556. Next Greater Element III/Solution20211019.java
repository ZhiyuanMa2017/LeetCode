import java.util.Arrays;

class Solution20211019 {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int i;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        char numberToChange = nums[i - 1];
        int smallestIndex = i;
        for (int j = nums.length - 1; j > i - 1; j--) {
            if (numberToChange < nums[j] && nums[j] <= nums[smallestIndex]) {
                smallestIndex = j;
            }
        }
        swap(nums, smallestIndex, i - 1);
        Arrays.sort(nums, i, nums.length);
        long res = Long.parseLong(String.valueOf(nums));
        return res < Integer.MAX_VALUE ? (int) res : -1;
    }

    private void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
