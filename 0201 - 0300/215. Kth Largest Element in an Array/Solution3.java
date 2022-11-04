class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001];
        for (int num : nums) {
            count[num + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            if (k <= count[i]) {
                return i - 10000;
            }
            k -= count[i];
        }
        return -1;
    }
}
