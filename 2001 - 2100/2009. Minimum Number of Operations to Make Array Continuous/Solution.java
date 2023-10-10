import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[size] = nums[i];
                size++;
            }
        }
        int cur;
        int i = 0;
        int j = 0;
        int n = nums.length;
        int res = 0;
        while (i < size) {
            cur = nums[i];
            while (j < size && nums[j] <= cur + n - 1) {
                j++;
            }
            res = Math.max(res, j - i);
            i++;
        }
        return n - res;
    }
}
