class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        int res = n;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) == '1' ? 1 : -1;
        }
        int curMin = nums[0];
        res = Math.min(res, curMin);
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin + nums[i], nums[i]);
            res = Math.min(res, curMin);
        }
        res = Math.min(res, 0);
        return res + n;
    }
}
