import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            int low = lower - num;
            int high = upper - num;
            if (low > nums[n - 1] || high < nums[i + 1]) {
                continue;
            } else {
                int l = i + 1;
                int h = n - 1;
                while (l < h) {
                    int mid = l + (h - l) / 2;
                    if (nums[mid] >= low) {
                        h = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                int index1 = l;
                l = i + 1;
                h = n - 1;
                while (l < h) {
                    int mid = l + (h - l + 1) / 2;
                    if (nums[mid] > high) {
                        h = mid - 1;
                    } else {
                        l = mid;
                    }
                }
                System.out.println(l + " " + index1);
                res += l - index1 + 1;
            }
        }
        return res;
    }
}
