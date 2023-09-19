class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int cur = nums[i];
            int toPut = cur - 1;
            if (nums[toPut] == cur) {
                if (i != toPut) {
                    return cur;
                } else {
                    i++;
                }
            } else {
                swap(nums, i, toPut);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
