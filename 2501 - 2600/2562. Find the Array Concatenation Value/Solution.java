class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (i == j) {
                res += nums[i];
            } else {
                res += Integer.parseInt("" + nums[i] + nums[j]);
            }
            i++;
            j--;
        }
        return res;
    }
}
