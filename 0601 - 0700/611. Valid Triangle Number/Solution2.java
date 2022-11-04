import java.util.Arrays;

class Solution2 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int cur = nums[i] + nums[j];
                int count = binarySearch(j, nums, cur);
                res += count;
            }
        }
        return res;
    }

    public int binarySearch(int s, int[] nums, int target) {
        int l = s + 1;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + h + 1 >> 1;
            if (nums[mid] >= target) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        if (nums[h] < target) {
            return h - s;
        }
        return 0;
    }
}
