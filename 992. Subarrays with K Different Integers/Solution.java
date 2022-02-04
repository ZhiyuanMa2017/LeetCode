class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] upper = new int[n];
        int[] lower = new int[n];
        find(upper, nums, k - 1);
        find(lower, nums, k);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += upper[i] - lower[i];
        }
        return res;
    }

    void find(int[] arr, int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int[] window = new int[n + 1];
        while (rightIndex < n) {
            int right = nums[rightIndex];

            if (window[right] == 0) {
                sum++;
            }
            window[right]++;
            while (sum > k) {
                int left = nums[leftIndex];
                leftIndex++;
                window[left]--;
                if (window[left] == 0) {
                    sum--;
                }
            }
            arr[rightIndex] = leftIndex;
            rightIndex++;
        }
    }
}
