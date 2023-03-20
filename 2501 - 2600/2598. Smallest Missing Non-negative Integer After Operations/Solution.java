class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];
        for (int num : nums) {
            num %= value;
            num += value;
            num %= value;
            count[num]++;
        }
        int res = 0;
        while (count[res % value] > 0) {
            count[res % value]--;
            res++;
        }
        return res;
    }
}
