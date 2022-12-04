class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long first = 0;
        long diff = Long.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            first += nums[i];
            sum -= nums[i];
            long front = first / (i + 1);
            long last;
            if (i == nums.length - 1) {
                last = 0;
            } else {
                last = sum / (nums.length - i - 1);
            }
            long cur = Math.abs(front - last);
            if (cur < diff) {
                diff = cur;
                res = i;
            }
        }
        return res;
    }
}
