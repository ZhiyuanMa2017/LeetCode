class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = (int) 1e6;
        while(low < high) {
            int mid = (low + high) >>> 1;
            int sum = 0;
            for (int num : nums) {
                sum += (num - 1) / mid + 1;
            }
            if(sum <= threshold) {
                high = mid;
            } else if (sum > threshold) {
                low = mid + 1;
            }
        }
        return low;
    }
}
