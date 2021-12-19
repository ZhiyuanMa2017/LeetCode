class Solution20211219 {
    public int jump(int[] nums) {
        int index = 0;
        int curEnd = 0;
        int curFar = 0;
        int n = nums.length;
        int res = 0;
        while (index < n - 1 && index <= curEnd) {
            while (index < n - 1 && index <= curEnd) {
                curFar = Math.max(curFar, nums[index] + index);
                index++;
                if (curFar >= n - 1) {
                    return res + 1;
                }
            }
            res++;
            curEnd = curFar;
        }
        return res;
    }
}
