import java.util.Arrays;

class Solution2 {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for (int num : nums) {
            count[num + 100]++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = count[nums[i] + 100] * 201 + 100 - nums[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 100 - nums[i] % 201;
        }
        return nums;
    }
}
