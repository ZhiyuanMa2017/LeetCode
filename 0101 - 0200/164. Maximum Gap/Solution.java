import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;

        }
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] bucketsMin = new int[nums.length - 1];
        int[] bucketsMax = new int[nums.length - 1];
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            int i = (num - min) / gap;
            bucketsMax[i] = Math.max(num, bucketsMax[i]);
            bucketsMin[i] = Math.min(num, bucketsMin[i]);
        }

        int maxGap = Integer.MIN_VALUE;
        int prev = min;
        for (int j = 0; j < nums.length - 1; j++) {
            if (bucketsMax[j] == Integer.MIN_VALUE && bucketsMin[j] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketsMin[j] - prev);
            prev = bucketsMax[j];
        }
        maxGap = Math.max(maxGap, max - prev);
        return maxGap;
    }
}
