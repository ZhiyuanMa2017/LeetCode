import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        int[] preSum = new int[nums.length];
        Arrays.sort(nums);
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        Arrays.fill(res, nums.length);
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            for (int j = 0; j < nums.length; j++) {
                if (preSum[j] > q) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
