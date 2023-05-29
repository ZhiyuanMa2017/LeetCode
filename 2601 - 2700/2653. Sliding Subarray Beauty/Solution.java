class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += 50;
        }
        int[] count = new int[110];
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            count[num]++;
        }
        int cur = x;
        for (int i = 0; i < 101; i++) {
            cur -= count[i];
            if (cur <= 0) {
                res[0] = Math.min(0, i - 50);
                break;
            }
        }
        for (int i = k; i < n; i++) {
            count[nums[i - k]]--;
            count[nums[i]]++;
            cur = x;
            for (int j = 0; j < 101; j++) {
                cur -= count[j];
                if (cur <= 0) {
                    res[i - k + 1] = Math.min(0, j - 50);
                    break;
                }
            }
        }
        return res;
    }
}
