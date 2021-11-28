class Solution {
    public int[] getAverages(int[] nums, int k) {
        long last = -1L;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i + k < nums.length && i - k >= 0) {
                if (last == -1) {
                    long sum = 0;
                    for (int j = i - k; j <= 2 * k; j++) {
                        sum += nums[j];
                    }
                    res[i] = (int) (sum / (2 * k + 1));
                    last = sum;
                } else {
                    long sum = last;
                    sum = sum - nums[i - k - 1] + nums[i + k];
                    res[i] = (int) (sum / (2 * k + 1));
                    last = sum;
                }
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
