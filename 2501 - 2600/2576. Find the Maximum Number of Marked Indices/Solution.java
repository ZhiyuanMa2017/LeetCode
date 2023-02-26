import java.util.Arrays;

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int smallIndex = n / 2 - 1;
        int res = 0;
        for (int i = n - 1; i >= n / 2; i--) {
            while (smallIndex >= 0 && nums[smallIndex] * 2 > nums[i]) {
                smallIndex--;
            }
            if (smallIndex == -1) {
                break;
            }
            res += 2;
            smallIndex--;
        }
        return res;
    }
}
