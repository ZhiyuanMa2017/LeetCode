import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = binarySearch(arr, nums[i]);
            res[i] = count;
        }
        return res;
    }

    private int binarySearch(int[] arr, int num) {
        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] >= num) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
